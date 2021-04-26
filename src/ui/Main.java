package ui;

import model.PetCenter;

import java.util.Scanner;

public class Main {
    private Scanner sc;//it contains the instance of Scanner class
    private PetCenter petCenter;//it contains the instance of PetCenter class

    Main(){
        sc = new Scanner(System.in);
        petCenter = new PetCenter();
    }

    public static void main(String [] args){
        Main main = new Main();
        int option;

        do{
            option = main.showMenu();
            main.operations(option);
        }while(option != 0);
    }

    /**
     * <b>Description:</b> it shows the user's menu
     * @return <i>option int</i> it constains the option choosed by user
     * */

    public int showMenu(){
        int option;

        System.out.println("What do you wanna do\n" +
                            "1. add a pet\n" +
                            "2. add a veterinary" 
                );

        option = sc.nextInt();
        sc.nextLine();

        return option;
    }

    /**
     * <b>Description:</b> it execute the operations
     * */

    public void operations(int option){
        switch(option){
            case 1:
                addPet();
                break;
            case 2:
                addVeterinary();
                break;
            case 3:
                break;
        }
    }

    /**
     * <b>Description:</b> it send the pet's information to class PetCenter 
     * */

    public void addPet(){
        String [] dataOwner = dataOwner();
        String [] dataPet = dataPet(dataOwner[1]);
        String species = getSpecies();
        String priority = getPriority();

        if(dataOwner[1] == "already"){
            System.out.println(petCenter.addPet(dataPet, species, priority));

        } else {
            System.out.println(petCenter.addPet(dataPet, species, priority, dataOwner));
        }
    }

    /**
     * <b>Description:</b> it gets the pet's data
     * @return <i>dataPet String []</i> it contains the pet's data
     * */

    public String [] dataPet(String verification){
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

        System.out.println("Enter pet's race");
        dataPet[2] = sc.nextLine();

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

    public String getSpecies(){
        String answer;//it constains user's answer
        boolean cent = true;//it controls the cycle do while

        do{
            System.out.println("Which is the species?");
            answer = sc.nextLine();

            if(answer.equalsIgnoreCase("dog")){
                cent = false;
            } else if(answer.equalsIgnoreCase("cat")){
                cent = false;
            } else if(answer.equalsIgnoreCase("rabbit")){
                cent = false;
            } else if(answer.equalsIgnoreCase("reptile")){
                cent = false;
            } else if(answer.equalsIgnoreCase("bird")){
                cent = false;
            } else {
                System.out.println("The option is wrong");
            }
        }while(cent);

        return answer;
    }

    /**
     * <b>Description:</b> it send the veterinary's information to class PetCenter
     * */

    public void addVeterinary(){
        String [] data = dataVeterinary();

        petCenter.addVeterinary(data);
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

    }
}
