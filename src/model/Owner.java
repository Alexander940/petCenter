package model;

/**
 * <b>Description</b> this class contains attributes and methods of a owner
 * @author Alexander Echeverry
 * @version 1.0
 * @see Person
 * */

public class Owner extends Person {
    private String phone;
    private String address;

    /**
     * <b>Description</b> it's constructor method
     * @param id <i>String</i> it conatins owner's identify
     * @param name <i>String</i> it conatins owner's name 
     * @param phone <i>String</i> it contains owner's phone
     * @param address <i>String</i> it contains owner's address
     * */

    public Owner(String id, String name, String phone, String address){
        super(id, name);

        this.phone = phone;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Owner{" +
                super.toString() +
                ", phone=" + phone +
                ", address=" + address +
                '}';
    }
}
