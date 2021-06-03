package model;

/**
 * <b>Description:</b> this class contains the attributes of methods of a habitat
 * @author Alexander Echeverry
 * @version 1.0
 */

public abstract class Habitat {

    private String id;//it contains habitat's id
    private String longHabitat;//it contains habitat's long
    private String width;//it contains habitat's width
    private HabitatState habitatState;//it contains habitat's state
    private Pet pet;//it contains the pet into habitat

    public Habitat(String id, String longHabitat, String width) {
        this.id = id;
        this.longHabitat = longHabitat;
        this.width = width;
        this.habitatState = HabitatState.EMPTY;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public String getId() {
        return id;
    }

    public HabitatState getHabitatState() {
        return habitatState;
    }

    public void setHabitatState(HabitatState habitatState) {
        this.habitatState = habitatState;
    }
}
