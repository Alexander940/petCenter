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
}
