package model;

/**
 * <b>Description:</b> this class contains the attributes of methods of a reptile habitat
 * @author Alexander Echeverry
 * @version 1.0
 * @see Habitat
 */

public class ReptileHabitat extends Habitat {

    private String material;//it contains the material of habitat
    private TypeHabitatReptile typeHabitatReptile;//it contains the type habitat (amphibian or earth)

    public ReptileHabitat(String id, String longHabitat, String width, String material, TypeHabitatReptile typeHabitatReptile) {
        super(id, longHabitat, width);
        this.material = material;
        this.typeHabitatReptile = typeHabitatReptile;
    }
}
