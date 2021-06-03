package model;

/**
 * <b>Description:</b> this class contains the attributes of methods of a rabbit habitat
 * @author Alexander Echeverry
 * @version 1.0
 * @see Habitat
 */

public class RabbitHabitat extends Habitat {

    private String typePlant;//it contains the type plants in the habitat
    private int numPlants;//it contains the number of plants in the habitat

    public RabbitHabitat(String id, String longHabitat, String width, String typePlant, int numPlants) {
        super(id, longHabitat, width);
        this.typePlant = typePlant;
        this.numPlants = numPlants;
    }
}
