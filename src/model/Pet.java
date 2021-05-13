package model;

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

    public Pet(String name, String age, String symptom, Species species, State state, Priority priority, Owner owner){
        this.name = name;
        this.age = age;
        this.symptom = symptom;
        this.species = species;
        this.state = state;
        this.priority = priority;
        this.owner = owner;
    }

    /**
     * <b>Description:</b> it get pet into appoinment
     * <b>pre:</b> state should be
     * @param veterinary <i>Veterinary</i> it contains the pet's veterinary
     * */

    public void getOnAppoinment(Veterinary veterinary){
        state = State.CONSULT;
        this.veterinary = veterinary;
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
}
