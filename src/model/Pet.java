package model;

/**
 * <b>Description</b> this class contains the attributes and methods of a pet
 * @author Alexander Echeverry
 * @version 1.0
 * */

public class Pet {
    private String name;//it's pet's name
    private String age;//it's pet's age 
    private String race;//it's pet's race
    private String symptom;//it's pet's symptom
    private Species species;//it's pet's species
    private State state;//it's pet's state
    private Priority priority;//it's pet's priority
    private Owner owner;//it's pet's owner
    private Veterinary veterinary;//it's pet's veterinary

    /**
     * <b>Description:</b> it's constructor method, it creates a pet with his race
     * @param name <i>String</i> it contains pet's name
     * @param age <i>String</i> it contains pet's age
     * @param race <i>String</i> it contains pet's race
     * @param symptom <i>String</i> it contains pet's symptom
     * @param species <i>Species</i> it contains pet's species
     * @param state <i>State</i> it contains pet's state
     * @param priority <i>Priority</i> it contains pet's priority
     * @param owner <i>Owner</i> it contains pet's owner
     * */

    public Pet(String name, String age, String race, String symptom, Species species, State state, Priority priority, Owner owner){
        this.name = name;
        this.age = age;
        this.race = race;
        this.symptom = symptom;
        this.species = species;
        this.state = state;
        this.priority = priority;
        this.owner = owner;
    }

    /**
     * <b>Description:</b> it's constructor method, it creates a pet without his race
     * @param name <i>String</i> it contains pet's name
     * @param age <i>String</i> it contains pet's age
     * @param symptom <i>String</i> it contains pet's symptom
     * @param species <i>Species</i> it contains pet's species
     * @param state <i>State</i> it contains pet's state
     * @param priority <i>Priority</i> it contains pet's priority
     * @param owner <i>Owner</i> it contains pet's owner
     * */

    public Pet(String name, String age, String symptom, Species species, State state, Priority priority, Owner owner){
        this.name = name;
        this.age = age;
        this.symptom = symptom;
        this.species = species;
        this.state = state;
        this.priority = priority;
        this.owner = owner;
    }

    public Pet(String name, String age, String race, Species species, Owner owner) {
        this.name = name;
        this.age = age;
        this.owner = owner;
        this.race = race;
        this.species = species;
    }

    /**
     * <b>Description:</b> it get pet into appoinment
     * <b>pre:</b> state should be
     * @param veterinary <i>Veterinary</i> it contains the pet's veterinary
     * */

    public void getIntoAppointment(Veterinary veterinary){
        state = State.CONSULT;
        this.veterinary = veterinary;
    }

    /**
     * <b>Description:</b> it get pet out of appoinment
     * @param state <i>State</i>
     * */

    public void getOutAppointment(State state){
        this.state = state;
    }

    /**
     * <b>Description:</b> it allows get the value of priority
     * @return <i>priority Priority</i> it contains the value of priority
     * */

    public Priority getPriority(){
        return priority;
    }

    /**
     * <b>Description:</b> it allows get the value of state
     * @return <i>state State</i> it contains state's value
     * */

    public State getState(){
        return state;
    }

    /**
     * <b>Description:</b> it allows get the value of owner
     * @return <i>owner Owner</i> it contains owner's value
     * */

    public Owner getOwner(){
        return owner;    
    }

    /**
     * <b>Description:</b> it allows get the value of name
     * @return <i>name String</i> it contains the name's value
     * */

    public String getName(){
        return name;
    }
    
    /**
     * <b>Description:</b> it allows get the veterinary's value<br>
     * <b>pre:</b> veterinary should be
     * */

    public Veterinary getVeterinary(){
        return veterinary;
    }

    /**
     * <b>Description:</b> it allows changing the value of state<br>
     * <b>pos:</b> state changes his value
     * */

    public void setState(State state){
        this.state = state;
    }

    public Species getSpecies() {
        return species;
    }
}
