package model;

public class PetCenter {
    public int MAX_VETERINARIES = 7;//it's the maximum of veterinaries
    public int MAX_PETS = 120;//it's the maximum of pets allowed per day
    private int petNumber;//it contains the number of pets in the pet center
    private int vetNumber;// it contains the number of veterinaries in the pet center
    private Pet [] pets;//it contains all instans of pets
    private Veterinary [] veterinaries;// it contains all instances of veterinaries
    private int [] petPosition;//it contains the positions where a same owner have pets
    private Owner owner;//it contains the owner to assign the new pet

    public PetCenter(){
        pets = new Pet[MAX_PETS];
        petPosition = new int[MAX_PETS];
        veterinaries = new Veterinary[MAX_VETERINARIES];    
        petNumber = 0;
        vetNumber = 0;
    }

    /**
     * <b>Description:</b> it creates a instance of Pet in array pets with a new owner<br>
     * <b>pre:</b> array pets should be and it should be contain less than one hundred twenty instances, petNumber should be type int<br>
     * <b>pos:</b> pets contains a new instance, petNumber sum one 
     * @param dataPet <i>String []</i> it contains the pet's information
     * @param species <i>Species</i> it contains pet's species
     * @param priority <i>Priority</i> it contains pet's priority
     * @param dataOwner <i>String []</i> it contains the information of pet's owner
     */

    public String addPet(String [] dataPet, String species, String priority, String [] dataOwner){
        Species cSpecies = getSpecies(species);
        Priority cPriority = getPriority(priority);
        if(dataPet[2] == null){
            pets[petNumber] = new Pet(dataPet[0], dataPet[1], dataPet[3], cSpecies, State.WAITING, cPriority, new Owner(dataOwner[0], dataOwner[1], dataOwner[2], dataOwner[3]));    
        } else {
            pets[petNumber] = new Pet(dataPet[0], dataPet[1], dataPet[2], dataPet[3], cSpecies, State.WAITING, cPriority, new Owner(dataOwner[0], dataOwner[1], dataOwner[2], dataOwner[3]));
        }
        petNumber++;

        return "Pet was created";
    }

    /**
     * <b>Description:</b> it creates a instance of Pet in array pets with a existing owner<br>
     * <b>pre:</b> array pets should be and it should be contain less than one hundred twenty instances, petNumber should be type int<br>
     * <b>pos:</b> pets contains a new instance, petNumber sum one 
     * @param dataPet <i>String []</i> it contains the pet's information
     * @param species <i>Species</i> it contains pet's species
     * @param priority <i>Priority</i> it contains pet's priority
     */

    public String addPet(String [] dataPet, String species, String priority){
        Species cSpecies = getSpecies(species);
        Priority cPriority = getPriority(priority);
        if(dataPet[2] == null){
            pets[petNumber] = new Pet(dataPet[0], dataPet[1], dataPet[3], cSpecies, State.WAITING, cPriority, this.owner);
        } else {
            pets[petNumber] = new Pet(dataPet[0], dataPet[1], dataPet[2], dataPet[3], cSpecies, State.WAITING, cPriority, this.owner); 
        }
        petNumber++;

        return "Pet was created";
    }

    /**
     * <b>Description:</b> it reads the species in type String and converting it to type Species
     * @param species <i>String</i> it contains the species 
     * @return <i>cSpecies Species</i> it contains the species in type Species
     * */

    public Species getSpecies(String species){
        Species cSpecies = Species.DOG;//it's method's return

        if(species.equalsIgnoreCase("dog")){
            cSpecies = Species.DOG;
        } else if(species.equalsIgnoreCase("cat")){
            cSpecies = Species.CAT;
        } else if(species.equalsIgnoreCase("rabbit")){
            cSpecies = Species.RABBIT;
        } else if(species.equalsIgnoreCase("reptile")){
            cSpecies = Species.REPTILE;
        } else if(species.equalsIgnoreCase("bird")){
            cSpecies = Species.BIRD;
        }

        return cSpecies;
    }

    /**
     * <b>Description:</b> it gets priority in type string and converting to type Priority 
     * @param priority <i>String</i> it contains the priority in type String
     * @return <i>cPriority Priority</i> it contains the priority in type Priority
     * */

    public Priority getPriority(String priority){
        Priority cPriority = Priority.BLUE;//it's method's return

        if(priority.equalsIgnoreCase("red")){
            cPriority = Priority.RED;
        } else if(priority.equalsIgnoreCase("orange")){
            cPriority = Priority.ORANGE;
        } else if(priority.equalsIgnoreCase("yellow")){
            cPriority = Priority.YELLOW;
        } else if(priority.equalsIgnoreCase("green")){
            cPriority = Priority.GREEN;
        } else if(priority.equalsIgnoreCase("blue")){
            cPriority = Priority.BLUE;
        }

        return cPriority;
    }

    /**
     * <b>Description:</b> it creates a instance of Veterinary<br>
     * <b>pre:</b> veterinaries should be and it should contains less than seven intances, vetNumber and vetsAvailable should be type int<br>
     * <b>pos:</b> veterinaries get a new instance and vetNumber sum one
     * @param data <i>String[]</i> it contain veterinary's information 
     * @param veterinaryState <i>VeterinaryState</i> it contains the veterinary's state
     * */

    public String addVeterinary(String [] data){
        String feedback;

        if(vetNumber <= 7){
            veterinaries[vetNumber] = new Veterinary(data[0], data[1], data[2], data[3], VeterinaryState.FREE);
            vetNumber++;
            feedback = "veterinary was created";
        } else {
            feedback = "there are already 7 veterinaries, you can't add any other";
        }

        return feedback;
    }

    /**
     * <b>Description:</b> it starts an appoinment<br>
     * <b>pre:</b> the instance called should be in veterinaries, vetsAvailable rest one
     * @return <i>feedback String</i> it contains feedback about starting a appoinment
     * */

    public String startAppoinment(){
        String feedback = "";//it's method's return
        int positionVeterinary = findFreeVeterinary();//it contains the position with a free veterinary
        int positionPet = nextPet();//it contains the postion of next pet to be assits

        if(positionVeterinary != -1 && positionPet != -1){
            pets[positionPet].getOnAppoinment(veterinaries[positionVeterinary]);
            veterinaries[positionVeterinary].startAppoinment();
            feedback = "The pet " + pets[positionPet].getName() + " of " + pets[positionPet].getOwner().getName() + "is into consult " + "\n" +
                "with veterinary " + veterinaries[positionVeterinary].getName() + "\n" + 
                "veterinary's identify is " + veterinaries[positionVeterinary].getId();
        } else {
            if(vetNumber == 0){
                feedback = "There aren't veterinaries yet \n";
            } else if(positionVeterinary == -1){
                feedback = "There aren't veterinaries available \n";
            }

            if(petNumber == 0){
                feedback += "There aren't pets yet";
            } else if(positionPet == -1){
                feedback += "There aren't pets to be assits";
            }
        }

        return feedback;
    }

    /**
     * <b>Description:</b> it find a free veterinary <br>
     * <b>pre:</b> array veterinaries should be
     * @return <i>position int</i> it contains the position of free veterinary
     * */

    public int findFreeVeterinary(){
        int position = -1;// it's method's return

        for(int i = 0; i < vetNumber; i++){
            if(veterinaries[i].getVeterinaryState() == VeterinaryState.FREE){
                position = i;
            }
        }

        return position;
    }

    /**
     * <b>Description:</b> it finds the next Pet for being assist 
     * @return <i>nextPet int</i> it contains the position of next petfor being assits in array pets
     * */

    public int nextPet(){
        int nextPet = 0;//it's method's return

        nextPet = nextPetPriority(Priority.RED);

        if(nextPet == -1){
            nextPet = nextPetPriority(Priority.ORANGE);
        }

        if(nextPet == -1){
            nextPet = nextPetPriority(Priority.YELLOW);
        }

        if(nextPet == -1){
            nextPet = nextPetPriority(Priority.GREEN);
        }

        if(nextPet == -1){
            nextPet = nextPetPriority(Priority.BLUE);
        }

        return nextPet;
    }

    /**
     * <b>Description:</b> it gets the position of next pet in a priority
     * @param mPriority <i>Priority</i> it contains the priority for searching
     * @return <i>nextPet int</i> it contains the position
     * */

    public int nextPetPriority(Priority mPriority){
        int nextPet = -1;//it's method's return
        boolean cent = false;//it controls cycle for

        for(int i = 0; i < petNumber && !cent; i++){
            if(pets[i].getState() == State.WAITING && pets[i].getPriority() == mPriority){
                nextPet = i;
                cent = true;
            }
        } 

        if(!cent){
            nextPet = -1;
        }

        return nextPet;
    }

    /**
     * <b>Description:</b> it finds owners and save the position where he have pets and it assign him to create a new pet<br>
     * <b>pre:</b> pets should be and it should have instances<br>
     * <b>pos:</b> owner gets a instances of the owner found
     * @param name <i>String</i> it contains owner's name for finding
     * @return <i>toogle boolean</i> it contains feedback about if owner was found
     * */

    public boolean findOwner(String name){
        boolean toogle = false;
        int count = 0;

        for(int i = 0;pets[i] != null && i < petNumber; i++){
            if(pets[i].getOwner().getName().equalsIgnoreCase(name)){
                toogle = true;
                petPosition[count] = i;
                owner = pets[i].getOwner();
            }
        }
        
        return toogle;
    }

    /**
     * <b>Description:</b> it finds a pet with its name<br>
     * <b>pre:</b> array pets shuould be and it should contain instances
     * @param name <i>String</i> it contains the pet's name for searching
     * @return <i>toogle boolean</i> it contains feedback about if pet was found
     * */
    public boolean findPet(String name){
        boolean toogle = false;
        
        for(int i = 0; i < petPosition.length && !toogle; i++){
            if(pets[petPosition[i]].getName().equalsIgnoreCase(name)){
                toogle = true;
            }
        }

        return toogle;
    }

    /**
     * <b>Description:</b> it changes of values of array petPosition to 0
     * */

    public void clearPetPosition(){
        for(int i = 0; i < petPosition.length; i++){
            petPosition[i] = 0;
        }
    }
}   
