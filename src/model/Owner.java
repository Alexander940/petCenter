package model;

public class Owner extends Person {
    private String phone;
    private String address;

    public Owner(String id, String name, String phone, String address){
        super(id, name);

        this.phone = phone;
        this.address = address;
    }
}
