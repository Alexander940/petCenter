package model;

public class Veterinary extends Person {
    private String lastname;//it's lastname of veterinary 
    private String idVeterinary;//it's veterinary's identifier
    private VeterinaryState veterinaryState;//it contains the veterinary's state

    Veterinary(String id, String name, String lastname, String idVeterinary, VeterinaryState veterinaryState){
        super(id, name);

        this.veterinaryState = veterinaryState;
        this.lastname = lastname;
        this.idVeterinary = idVeterinary;
    }

    public void startAppoinment(){
        this.veterinaryState = VeterinaryState.CONSULT;
    }
}
