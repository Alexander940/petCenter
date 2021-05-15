package model;

/**
 * <b>Description:</b> this class contains the attributes and methods of a veterinary
 * @author Alexander Echeverry
 * @version 1.0
 * @see Person
 * */

public class Veterinary extends Person {
    private String lastname;//it's lastname of veterinary 
    private String idVeterinary;//it's veterinary's identifier
    private VeterinaryState veterinaryState;//it contains the veterinary's state
    private int appointmentsNumber;//it contains the number of appointments vet has done

    /**
     * <b>Description:</b> it's constructor method
     * @param id <i>String</i> it contains vet's identify
     * @param name <i>String</i> it contains vet's name
     * @param lastname <i>String</i> it contains vet's lastname
     * @param idVeterinary <i>String</i> it contains vet's identify special with a vet
     * @param veterinaryState <i>VeterinaryState</i> it contains vet's state
     * */

    Veterinary(String id, String name, String lastname, String idVeterinary, VeterinaryState veterinaryState){
        super(id, name);

        this.veterinaryState = veterinaryState;
        this.lastname = lastname;
        this.idVeterinary = idVeterinary;
        this.appointmentsNumber = 0;
    }

    /**
     * <b>Description:</b> it changes veterinary state to consult 
     * */

    public void startAppoinment(){
        this.veterinaryState = VeterinaryState.CONSULT;
        this.appointmentsNumber++;
    }

    /**
     * <b>Description:</b> it allows get the value of veterinary's state <br>
     * <b>pre:</b> veterinaryState should be
     * */

    public VeterinaryState getVeterinaryState(){
        return veterinaryState;
    }

    /**
     * <b>Description:</b> it changes the veterinary state
     * */

    public void getOutAppointment(){
        this.veterinaryState = VeterinaryState.FREE;
    }

    /**
     * <b>Description:</b> it allows get the appointmentsNumber's value<br>
     * <b>pre:</b> appointmentsNumber should be
     * */

    public int getAppointmentsNumber(){
        return appointmentsNumber;
    }
}
