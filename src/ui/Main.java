package ui;

import model.PetCenter;

import java.util.Scanner;

/**
 * it's main class
 * @author Alexander Echeverry
 * @version 1.0
 * */

public class Main {
    private Scanner sc;//it contains the instance of Scanner class
    private PetCenter petCenter;//it contains the instance of PetCenter class

    /**
     * it's constructor method
     * */

    private Main(){
        sc = new Scanner(System.in);
        petCenter = new PetCenter();
    }

    public static void main(String [] args){
        Main ppal = new Main();
        int option;
        boolean toggle;

        do{
            option = ppal.showMenu();
            toggle = ppal.operations(option);
        }while(toggle);
    }

    /**
     * <b>Description:</b> it shows the user's menu
     * @return <i>option int</i> it constains the option choosed by user
     * */

    public int showMenu(){
        int option;

        System.out.println("What do you wanna do\n" +
                            "1. add a pet\n" +
                            "2. add a veterinary \n" + 
                            "3. starting appointment \n" +
                            "4. ending appointment \n" +
                            "5. number of pets without attention\n" +
                            "6. delete a veterinary\n" +
                            "7. remove a pet without attention\n" +
                            "0. Close petCenter"
                );

        option = sc.nextInt();
        sc.nextLine();

        return option;
    }

    /**
     * <b>Description:</b> it execute the operations
     * */

    public boolean operations(int option){
        boolean toggle = true;

        switch(option){
            case 1:
                addPet();
                break;
            case 2:
                addVeterinary();
                break;
            case 3:
                startAppointment();
                break;
            case 4:
                endAppointment();
                break;
            case 5:
                findPets();
                break;
            case 6:
                deletedVeterinary();
                break;
            case 7: 
                removePet();
                break;
            case 0: 
                toggle = closePetCenter();
                break;
        }

        return toggle;
    }

    /**
     * <b>Description:</b> it send the pet's information to class PetCenter 
     * */

    public void addPet(){
        String [] dataOwner = dataOwner();
        String [] species = getSpecies();
        String [] dataPet = dataPet(dataOwner[1], species[1]);
        String priority = getPriority();

        if(dataOwner[1] == "already"){
            System.out.println(petCenter.addPet(dataPet, species[0], priority));

        } else {
            System.out.println(petCenter.addPet(dataPet, species[0], priority, dataOwner));
        }
    }

    /**
     * <b>Description:</b> it gets the pet's data
     * @return <i>dataPet String []</i> it contains the pet's data
     * */

    public String [] dataPet(String verification, String raceVerification){
        String [] dataPet = new String[4];
        boolean toogle = false;
        boolean cent = false;
        
        do{
            System.out.println("Enter pet's name");
            dataPet[0] = sc.nextLine();
            if(verification == "already"){
                cent = petCenter.findPet(dataPet[0]);
                if(cent){
                    System.out.println("This owner already have a pet with this name"); 
                    toogle = true;
                } else {
                    toogle = false;
                    petCenter.clearPetPosition();
                }
            }
        }while(toogle);

        System.out.println("Enter pet's age");
        dataPet[1] = sc.nextLine();

        if(raceVerification == null){
            System.out.println("Enter pet's race");
            dataPet[2] = sc.nextLine();
        }

        System.out.println("Enter pet's symptom");
        dataPet[3] = sc.nextLine();

        return dataPet;
    }

    /**
     * <b>Description:</b> it gets the owner's data
     * @return <i>dataOwner String []</i> it contains the owner's data
     * */

    public String [] dataOwner(){
        String [] dataOwner = new String[4];//it's method's return
        boolean toogle = true;//it gets feedback about the existence of the name


        System.out.println("Enter owner's name");
        dataOwner[1] = sc.nextLine();
        toogle = petCenter.findOwner(dataOwner[1]);

        if(toogle){
            System.out.println("This owner is already");
            dataOwner[1] = "already";
        }

        if(!toogle){
            System.out.println("Enter owner's identify");
            dataOwner[0] = sc.nextLine();

            System.out.println("Enter owner's phone");
            dataOwner[2] = sc.nextLine();

            System.out.println("Enter owner's address");
            dataOwner[3] = sc.nextLine();
        }

        return dataOwner;
    }

    /**
     * <b>Description:</b> it gets the pet's priority 
     * @return <i>priority Priority</i> it contains the pet's priority
     * */

    public String getPriority(){
        String answer;
        boolean cent = true;//it controls the cycle do while

        
        do{
            System.out.println("Which is the priority?");
            System.out.println("red, orange, yellow, green, blue");
            answer = sc.nextLine();

            if(answer.equalsIgnoreCase("red")){
                cent = false;
            } else if(answer.equalsIgnoreCase("orange")){
                cent = false;
            } else if(answer.equalsIgnoreCase("yellow")){
                cent = false;
            } else if(answer.equalsIgnoreCase("green")){
                cent = false;
            } else if(answer.equalsIgnoreCase("blue")){
                cent = false;
            } else {
                System.out.println("Option wrong");
            }
        }while(cent);
        
        return answer;
    }

    /**
     * <b>Description:</b> it return the pet's species in type Species
     * @return <i>species Species</i> it constains the pet's species
     * */

    public String [] getSpecies(){
        String [] answer = new String[2];//it constains user's answer
        boolean cent = true;//it controls the cycle do while

        do{
            System.out.println("Which is the species?");
            answer[0] = sc.nextLine();

            if(answer[0].equalsIgnoreCase("dog")){
                cent = false;
            } else if(answer[0].equalsIgnoreCase("cat")){
                cent = false;
            } else if(answer[0].equalsIgnoreCase("rabbit")){
                cent = false;
            } else if(answer[0].equalsIgnoreCase("reptile")){
                cent = false;
            } else if(answer[0].equalsIgnoreCase("bird")){
                cent = false;
            } else {
                System.out.println("The option is wrong");
            }
        }while(cent);

        if(answer[0].equalsIgnoreCase("rabbit") || answer[0].equalsIgnoreCase("reptile") || answer[0].equalsIgnoreCase("bird")){
            answer[1] = "race no required";
        }

        return answer;
    }

    /**
     * <b>Description:</b> it send the veterinary's information to class PetCenter
     * */

    public void addVeterinary(){
        String [] data = dataVeterinary();

        System.out.println(petCenter.addVeterinary(data));
    }

    /**
     * <b>Description:</b> it gets and return veterinary's data
     * @return <i>data String []</i> it contains veterinary's data 
     * */

    public String [] dataVeterinary(){
        String [] data = new String[4];

        System.out.println("Enter veterinary's identify");
        data[0] = sc.nextLine();

        System.out.println("Enter veterinary's name");
        data[1] = sc.nextLine();

        System.out.println("Enter veterinary's lastname");
        data[2] = sc.nextLine();

        System.out.println("Enter special veterinary's identify");
        data[3] = sc.nextLine();

        return data;
    }

    /**
     * <b>Description:</b> it starts a appointment
     * */

    public void startAppointment(){
        System.out.println(petCenter.startAppointment());
    }

    /**
     * <b>Description:</b> it ends a appointment
     * */

    public void endAppointment(){
        String petName;//it contains the pet's name to get out of appointment
        String idVeterinary;//it constains the veterinary's id to get out of appointment
        String state = "";// it contains the state to assign to the pet
        boolean cent = true;//it controls the cycle do while

        System.out.println("Enter pet's name");    
        petName = sc.nextLine();

        System.out.println("Enter veterinary's identify");
        idVeterinary = sc.nextLine();

        do{
            System.out.println("Enter transfer if the pet needs to be hospitalized or authorized if the pet can go out the pet center");
            state = sc.nextLine();

            if(state.equalsIgnoreCase("transfer")){
                cent = false;
            } else if(state.equalsIgnoreCase("authorized")){
                cent = false;
            }
        }while(cent);

        System.out.println(petCenter.endAppointment(petName, idVeterinary, state));
    }

    /**
     * <b>Description:</b> it gets and showing the number of pets waiting for assisting
     * */

    public void findPets(){
        System.out.println("The number of pets waiting for assisting is " + petCenter.findPets());
    }

    /**
     * <b>Description:</b> it gets the vet's identify for deleted and it shows feedback about process
     * */

    public void deletedVeterinary(){
        String id;//it constains the vet's identify to delete

        System.out.println("Enter vet's identify");
        id = sc.nextLine();

        System.out.println(petCenter.deleteVeterinary(id));
    }

    /**
     * <b>Description:</b> it gets the pet and owner's name and it shows feedback about if pet was remove
     * */

    public void removePet(){
        String petName;//it contains the pet's name to remove it
        String ownerName;//it contains the owner's name of pet to remove it

        System.out.println("Enter pet's name");
        petName = sc.nextLine();

        System.out.println("Enter owner's name");
        ownerName = sc.nextLine();

        System.out.println(petCenter.removePet(petName, ownerName));
    }

    /**
     * <b>Description:</b> it gets and it shows the statistics of pet center
     * */

    public boolean closePetCenter(){
        String feedback = petCenter.closePetCenter();
        boolean toggle = false;

        System.out.println(feedback);

        if(feedback.equalsIgnoreCase("There are pets waiting for being to assits, you can't close the pet center")){
            toggle = true;
        }
        
        return toggle;
    }
}
