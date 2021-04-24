package model;

public class PetCenter {
    public int MAX_VETERINARIES = 7;//it's the maximum of veterinaries
    public int MAX_PETS = 120;//it's the maximum of pets allowed per day
    private int vetsAvailable;//it contains the number of veterinaries avalaible
    private int petNumber;//it contains the number of pets in the pet center
    private int vetNumber;// it contains the number of veterinaries in the pet center
    private Pet [] pets;//it contains all instans of pets
    private Veterinary [] veterinaries;// it contains all instans of veterinaries

    public PetCenter(){
        pets = new Pet[MAX_PETS];
        veterinaries = new Veterinary[MAX_VETERINARIES];    
        petNumber = 0;
        vetNumber = 0;
    }

    /**
     * <b>Description:</b> it creates a instance of Pet in array pets 
     * <b>pre:</b> array pets should be
     * <b>pos:</b> pets contains a new instance 
     * @param age <i>int</i> it's pet's age
     */

    public void addPet(String [] dataPet, Species species, State state, Priority priority, String [] dataOwner){
        pets[petNumber] = new Pet(dataPet[0], dataPet[1], dataPet[2], dataPet[3], species, state, priority, new Owner(dataOwner[0], dataOwner[1], dataOwner[2], dataOwner[3]));
        petNumber++;
    }

    public void addVeterinary(String [] data){
        veterinaries[vetNumber] = new Veterinary(data[0], data[1], data[2], data[3]);
        vetNumber++;
    }
}
