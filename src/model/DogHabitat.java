package model;

/**
 * <b>Description:</b> this class contains the attributes of methods of a dog habitat
 * @author Alexander Echeverry
 * @version 1.0
 * @see Habitat
 */

public class DogHabitat extends Habitat {

    private int numToys;//it contains the number of toys into habitat

    public DogHabitat(String id, String longHabitat, String width, int numToys) {
        super(id, longHabitat, width);
        this.numToys = numToys;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", numToys=" + numToys +
                "} \n";
    }
}
