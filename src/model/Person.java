package model;

/**
 * <b>Description:</b> this class contains the attributes of methods of a person
 * @author Alexander Echeverry
 * @version 1.0
 * */

public abstract class Person {
    private String id;
    private String name;

    /**
     * <b>Description:</b> it's constructor method
     * @param id <i>String</i> it contains person's identify
     * @param name <i>String</i> it contains person's name
     * */

    public Person(String id, String name){
        this.id = id;
        this.name = name;
    }

    /**
     * <b>Description:</b> it allows get the name's value <br>
     * <b>pre:</b> name should be
     * */

    public String getName(){
        return name;
    }

    /**
     * <b>Description:</b> it allows get the id's value <br>
     * <b>pre:</b> id should be
     * */

    public String getId(){
        return id;
    }
}
