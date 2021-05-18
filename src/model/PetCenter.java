package model;

/**
 * <b>Description:</b> this class contains the attributes and methods of a pet center
 * @author Alexander Echeverry
 * @version 1.0
 * */

public class PetCenter {
    public final int MAX_VETERINARIES = 7;//it's the maximum of veterinaries
    public final int MAX_PETS = 120;//it's the maximum of pets allowed per day
    private int petNumber;//it contains the number of pets in the pet center
    private int vetNumber;// it contains the number of veterinaries in the pet center
    private Pet [] pets;//it contains all instans of pets
    private Veterinary [] veterinaries;// it contains all instances of veterinaries
    private int [] petPosition;//it contains the positions where a same owner have pets
    private Owner owner;//it contains the owner to assign the new pet

    /**
     * <b>Description</b> it's constructor method
     * */

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

        String feedback = "Already there are 120 pets, you can't add any other pet";//it's method's return
        Species cSpecies = getSpecies(species);//it contains pet's species
        Priority cPriority = getPriority(priority);//it contains pet's priority

        if(petNumber < MAX_PETS){
            if(dataPet[2] == null){
                pets[petNumber] = new Pet(dataPet[0], dataPet[1], dataPet[3], cSpecies, State.WAITING, cPriority, new Owner(dataOwner[0], dataOwner[1], dataOwner[2], dataOwner[3]));    
            } else {
                pets[petNumber] = new Pet(dataPet[0], dataPet[1], dataPet[2], dataPet[3], cSpecies, State.WAITING, cPriority, new Owner(dataOwner[0], dataOwner[1], dataOwner[2], dataOwner[3]));
            }
            petNumber++;
            feedback = "Pet was created";
        }

        return feedback;
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

        String feedback = "Already there are 120 pets, you can't add any other pet";//it's method's return
        Species cSpecies = getSpecies(species);
        Priority cPriority = getPriority(priority);

        if(petNumber < MAX_PETS){
            if(dataPet[2] == null){
                pets[petNumber] = new Pet(dataPet[0], dataPet[1], dataPet[3], cSpecies, State.WAITING, cPriority, this.owner);
            } else {
                pets[petNumber] = new Pet(dataPet[0], dataPet[1], dataPet[2], dataPet[3], cSpecies, State.WAITING, cPriority, this.owner); 
            }
            petNumber++;
            feedback = "Pet was created";
        }

        return feedback;
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

    public String startAppointment(){
        String feedback = "";//it's method's return
        int positionVeterinary = findFreeVeterinary();//it contains the position with a free veterinary
        int positionPet = nextPet();//it contains the postion of next pet to be assits

        if(positionVeterinary != -1 && positionPet != -1){
            pets[positionPet].getIntoAppointment(veterinaries[positionVeterinary]);
            veterinaries[positionVeterinary].startAppoinment();
            feedback = "The pet " + pets[positionPet].getName() + " of " + pets[positionPet].getOwner().getName() + " is into consult " + "\n" +
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
     * <b>Description:</b> it ends a appointment
     * */

    public String endAppointment(String petName, String idVeterinary, String state){
        String feedback = "";//it's method's return
        int positionPet;//it contains the position of pet to get out appointment
        int positionVeterinary = findVeterinary(idVeterinary);//it contains the position of veterinary to get out appointment

        if(positionVeterinary != -1){
            positionPet = findPet(petName, veterinaries[positionVeterinary]);
            if(positionPet != -1){
                pets[positionPet].getOutAppointment(getState(state)); 
                veterinaries[positionVeterinary].getOutAppointment();
                feedback = "Appointment was ended";
            } else {
                feedback = "There isn't a pet with that veterinary";
            }
        } else {
            feedback = "There isn't a veterinary with that identify";
        }   

        return feedback;
    }

    /**
     * <b>Description:</b> it gets state in type string and converting to type State 
     * @param state <i>String</i> it contains the state in type String
     * @return <i>cState State</i> it contains the state in type State
     * */

    public State getState(String state){
        State cState = State.TRANSFER;

        if(state.equalsIgnoreCase("authorized")){
            cState = State.AUTHORIZED;
        }

        return cState;
    }

    /**
     * <b>Description:</b> it finds a pet with his name and his veterinary<br>
     * <b>pre:</b> array pets should be
     * @param name <i>String</i> it contains the pet's name for searching
     * @param veterinary <i>Veterinary</i> it contains the pet's veterinary for searching
     * @return <i>int Position</i> it contains the postion of pet found
     * */

    public int findPet(String name, Veterinary veterinary){
        int position = -1;//it's method's return

        for(int i = 0; i < petNumber; i++){
            if(pets[i].getName().equalsIgnoreCase(name) && pets[i].getVeterinary() == veterinary && pets[i].getState() == State.CONSULT){
                position = i;
            }
        }

        return position;
    }

    /**
     * <b>Description</b> it finds a veterinary with his identify<br>
     * <b>pre:</b> array veterinaries should be
     * @param id <i>String</i> it contains the identify of veterinary for searching 
     * @return <i>position int</i> it contains the position of veterinary found
     * */

    public int findVeterinary(String id){
        int position = -1;//it's method's return

        for(int i = 0; i < vetNumber; i++){
            if(veterinaries[i].getId().equalsIgnoreCase(id) && veterinaries[i].getVeterinaryState() == VeterinaryState.CONSULT){
                position = i;
            }
        }

        return position;
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
        boolean toogle = false;//it's method's return
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
        boolean toogle = false;//it's method's return
        
        for(int i = 0; i < petPosition.length && !toogle; i++){
            if(pets[petPosition[i]].getName().equalsIgnoreCase(name)){
                toogle = true;
            }
        }

        return toogle;
    }

    /**
     * <b>Description:</b> it changes all values of array petPosition to 0
     * */

    public void clearPetPosition(){
        for(int i = 0; i < petPosition.length; i++){
            petPosition[i] = 0;
        }
    }

    /**
     * <b>Description:</b> it finds pet in state waiting<br>
     * <b>pre:</b> array pets should be
     * @return <i>num int</i> it contains the number of pets waiting 
     * */

    public int findPets(){
        int num = 0;//it's method's return

        for(int i = 0; i < petNumber; i++){
            if(pets[i].getState() == State.WAITING){
                num++;
            }
        }

        return num;
    }

    /**
     * <b>Description:</b> it deletes a veterinary, it gets his identify
     * <b>Pre:</b> array veterinaries should be
     * <b>Pos:</b> if the vet is found, it deletes a object of array veterinaries
     * @return <i>feedback String</i> it contains feedback about if vet was deleted
     * */

    public String deleteVeterinary(String id){
        String feedback = "Already there are pet, you can't delete a veterinary";//it's method's return

        if(petNumber == 0){
            feedback = "There isn't a veterinary with this identify";
            for(int i = 0; i < vetNumber; i++){
                if(veterinaries[i].getId() == id){
                    veterinaries[i] = null;
                    feedback = "Veterinary was deleted";
                }
            }
        }

        return feedback;
    }

    /**
     * <b>Description:</b> it changes pet's state to without attention
     * @param petName <i>String</i> it contains pet's name to remove 
     * @param ownerName <i>String</i> it contains owner's name of pet to remove 
     * @return <i>feedback String</i> it return feedback about if pet was removed
     * */

    public String removePet(String petName, String ownerName){
        String feedback = "There isn't a pet with that name and that owner";//it's method's return
        
        for(int i = 0; i < petNumber; i++){
            if(pets[i].getName().equalsIgnoreCase(petName) && pets[i].getOwner().getName().equalsIgnoreCase(ownerName)){
                if(pets[i].getState() == State.WAITING){
                    pets[i].setState(State.WITHOUT_ATTENTION);
                    feedback = "The pet was removed";
                } else {
                    feedback = "This pet isn´t in waiting state, you can't remove it";
                }
            }
        }

        return feedback;
    }

    /**
     * <b>Description:</b> it return the statistics of pet center<br>
     * <b>pre:</b> array veterinaries should be
     * @return <i>feedback String</i> it contains the statistics of pet center
     * */

    public String closePetCenter(){
        String feedback = "";//it's method's return
        Veterinary vet = veterinaries[0];//it contains the vet with more appointments done
        int [] petsAssist = new int[5];//it contains tne number of pets assits per each priority
        int petsWithOutAttention = petsWithOutAttention();//it contains the number of pets without attention
        double percentage = 0.0;//it contains the percentage of pets they was gone without attention
        int petsWaiting = findPets();//it contains the number of pets in state wawiting
        String vetName = "";//it contains the vet's name with more appointments done

        if(petsWaiting == 0){
            for(int i = 0; i < vetNumber; i++){
                if(veterinaries[i].getAppointmentsNumber() > vet.getAppointmentsNumber()){
                    vet = veterinaries[i];
                }
            }

            petsAssist[0] = petsAssistPerPriority(Priority.RED);
            petsAssist[1] = petsAssistPerPriority(Priority.ORANGE);
            petsAssist[2] = petsAssistPerPriority(Priority.YELLOW);
            petsAssist[3] = petsAssistPerPriority(Priority.GREEN);
            petsAssist[4] = petsAssistPerPriority(Priority.BLUE);

            percentage = (petsWithOutAttention*100)/petNumber;

            if(vetNumber != 0){
                vetName = vet.getName();
            } else {
                vetName = "there aren't vets";
            }

            feedback = "The vet with more appointments is " + vetName + "\n" +
                       "in priority red was assits " + petsAssist[0] + " pets\n" +
                       "in priority orange was assits " + petsAssist[1] + " pets\n" +
                       "in priority yellow was assits " + petsAssist[2] + " pets\n" +
                       "in priority green was assits " + petsAssist[3] + " pets\n" +
                       "in priority blue was assits " + petsAssist[4] + " pets\n" +
                       "the percentage of pets they was gone with attention is " + percentage + "%";

            clearPets();
        } else {
            feedback = "There are pets waiting for being to assits, you can't close the pet center";
        }
        
        return feedback;
    }

    /**
     * <b>Description:</b> it gets the number of pets assits in a priority
     * <b>pre:</b> array pets should be
     * @param priority <i>Priority</i> it contains the priority for searching
     * @return <i>num int</i> it contains the number of pets assits in the priority
     * */

    public int petsAssistPerPriority(Priority priority){
        int num = 0;//it's method's return

        for(int i = 0; i < petNumber; i++){
            if(pets[i].getPriority() == priority && pets[i].getState() != State.WITHOUT_ATTENTION){
                num++;
            }
        }

        return num;
    }

    /**
     * <b>Description:</b> it finds pets in state without attention<br>
     * <b>pre:</b> array pets should be
     * @return <i>int num</i> it contains the number of pets in state without attention
     * */
    
    public int petsWithOutAttention(){
        int num = 0;//it's method's return 

        for(int i = 0; i < petNumber; i++){
            if(pets[i].getState() == State.WITHOUT_ATTENTION){
                num++;
            }
        }

        return num;
    }

    /**
     * <b>Description:</b> it resets the all values of array pets to null<br>
     * <b>pre:</b> array pets should be
     * */

    public void clearPets(){
        for(int i = 0; i < petNumber; i++){
            pets[i] = null;
        }
    }   
}   
