package model;

/**
 * <b>Description:</b> this class contains the attributes of methods of a bird habitat
 * @author Alexander Echeverry
 * @version 1.0
 * @see Habitat
 */

public class BirdHabitat extends Habitat {

    private int capacity;//it contains the capacity of cage
    private String height;//it contains the cage's height
    private TypeCage typeCage;//it contains the type of cage (hung up or flat)


    public BirdHabitat(String id, String longHabitat, String width, int capacity, String height, TypeCage typeCage) {
        super(id, longHabitat, width);
        this.capacity = capacity;
        this.height = height;
        this.typeCage = typeCage;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", capacity=" + capacity +
                ", height=" + height +
                ", typeCage=" + typeCage +
                "} \n";
    }
}
