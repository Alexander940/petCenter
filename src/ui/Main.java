package ui;

import model.PetCenter;
import model.Priority;
import model.Species;
import model.State;

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
        }while(false);
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
        }
    }

    /**
     * <b>Description:</b> it send the pet's information to class PetCenter 
     * */

    public void addPet(){
        Species species = getSpecies();
        String [] dataPet = dataPet();
        Priority priority = getPriority();
        String [] dataOwner = dataOwner();

        petCenter.addPet(dataPet, species, State.WAITING, priority, dataOwner);
    }

    /**
     * <b>Description:</b> it gets the pet's data
     * @return <i>dataPet String []</i> it contains the pet's data
     * */

    public String [] dataPet(){
        String [] dataPet = new String[4];
        
        System.out.println("Enter pet's name");
        dataPet[0] = sc.nextLine();

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
        String [] dataOwner = new String[4];

        System.out.println("Enter owner's identify");
        dataOwner[0] = sc.nextLine();

        System.out.println("Enter owner's name");
        dataOwner[1] = sc.nextLine();

        System.out.println("Enter owner's phone");
        dataOwner[2] = sc.nextLine();

        System.out.println("Enter owner's address");
        dataOwner[3] = sc.nextLine();

        return dataOwner;
    }

    /**
     * <b>Description:</b> it gets the pet's priority 
     * @return <i>priority Priority</i> it contains the pet's priority
     * */
    public Priority getPriority(){
        Priority priority = Priority.RED;
        String answer;

        System.out.println("Which is the priority?");
        System.out.println("red, orange, yellow, green, blue");
        answer = sc.nextLine();
        boolean cent = true;//it controls the cycle do while
        
        do{
            if(answer.equalsIgnoreCase("red")){
                priority = Priority.RED;
                cent = false;
            } else if(answer.equalsIgnoreCase("orange")){
                priority = Priority.ORANGE;
                cent = false;
            } else if(answer.equalsIgnoreCase("yellow")){
                priority = Priority.YELLOW;
                cent = false;
            } else if(answer.equalsIgnoreCase("green")){
                priority = Priority.GREEN;
                cent = false;
            } else if(answer.equalsIgnoreCase("blue")){
                priority = Priority.BLUE;
                cent = false;
            }
        }while(cent);
        
        return priority;
    }

    /**
     * <b>Description:</b> it return the pet's species in type Species
     * @return <i>species Species</i> it constains the pet's species
     * */

    public Species getSpecies(){
        Species species = Species.DOG;//it's method's return
        String answer;//it constains user's answer
        boolean cent = true;//it controls the cycle do while

        do{
            System.out.println("Which is the species");
            answer = sc.nextLine();

            if(answer.equalsIgnoreCase("dog")){
                species = Species.DOG;
                cent = false;
            } else if(answer.equalsIgnoreCase("cat")){
                species = Species.CAT;
                cent = false;
            } else if(answer.equalsIgnoreCase("rabbit")){
                species = Species.RABBIT;
                cent = false;
            } else if(answer.equalsIgnoreCase("reptile")){
                species = Species.REPTILE;
                cent = false;
            } else if(answer.equalsIgnoreCase("bird")){
                species = Species.BIRD;
                cent = false;
            } else {
                System.out.println("The option is wrong");
            }
        }while(cent);

        return species;
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
