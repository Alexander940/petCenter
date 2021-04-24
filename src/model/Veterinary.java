package model;

public class Veterinary extends Person {
    private String lastname;//it's lastname of veterinary 
    private String idVeterinary;//it's veterinary's identifier

    Veterinary(String id, String name, String lastname, String idVeterinary){
        super(id, name);

        this.lastname = lastname;
        this.idVeterinary = idVeterinary;
    }
}
