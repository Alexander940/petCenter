package model;

public abstract class Person {
    private String id;
    private String name;

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
