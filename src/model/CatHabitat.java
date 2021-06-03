package model;

/**
 * <b>Description:</b> this class contains the attributes of methods of a cat habitat
 * @author Alexander Echeverry
 * @version 1.0
 * @see Habitat
 */

public class CatHabitat extends Habitat {

    private String height;//it contains habitat's height
    private String maxWeight;//it contains the maximum of weight support

    public CatHabitat(String id, String longHabitat, String width, String height, String maxWeight) {
        super(id, longHabitat, width);
        this.height = height;
        this.maxWeight = maxWeight;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", height=" + height +
                ", maxWeight=" + maxWeight +
                "} \n";
    }
}
