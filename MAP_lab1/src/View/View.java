package View;

import java.util.Scanner;
import Controller.Controller;
import Model.IAquaAnimal;
import Repository.MyException;


public class View {
    Controller controller;
    Scanner scanner;

    public View(Controller controller){
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public Object[] inputData() throws MyException {
        System.out.println("Type(fish/turtle)=");
        String typeStr = this.scanner.nextLine();
        if(!typeStr.equals("fish") && !typeStr.equals("turtle"))
            throw new MyException("The type needs to be an fish/turtle!\n");

        System.out.println("ID=");
        String IDstr = this.scanner.nextLine();
        int ID;
        try{
            ID = Integer.parseInt(IDstr);
        }
        catch (RuntimeException exception){
            throw new MyException("The ID needs to be an integer number!\n");
        }

        System.out.println("Name=");
        String nameStr = this.scanner.nextLine();

        System.out.println("Age=");
        String ageStr = this.scanner.nextLine();
        int age;
        try{
            age = Integer.parseInt(ageStr);
        }
        catch (RuntimeException exception){
            throw new MyException("The age needs to be an integer number!\n");
        }

        Object[] attributes = new Object[4];
        attributes[0] = ID;
        attributes[1] = nameStr;
        attributes[2] = age;
        attributes[3] = typeStr;
        return attributes;
    }

    public void add(){
        Object[] attributes = new Object[4];
        try{
            attributes = inputData();
            int ID = (int)attributes[0];
            String name = (String)attributes[1];
            int age = (int)attributes[2];
            String type = (String)attributes[3];
            this.controller.add(ID, name, age, type);
        }
        catch (RuntimeException error) {
            System.out.println(error.getMessage());
        }
    }

    public void remove(){
        Object[] attributes = new Object[4];
        try{
            attributes = inputData();
            int ID = (int)attributes[0];
            String name = (String)attributes[1];
            int age = (int)attributes[2];
            String type = (String)attributes[3];
            this.controller.remove(ID, name, age, type);
        }
        catch (RuntimeException error) {
            System.out.println(error.getMessage());
        }
    }

    public void update(){
        Object[] attributes = new Object[4];
        try{
            attributes = inputData();
            int ID = (int)attributes[0];
            String name = (String)attributes[1];
            int age = (int)attributes[2];
            String type = (String)attributes[3];
            this.controller.update(ID, name, age, type);
        }
        catch (RuntimeException error) {
            System.out.println(error.getMessage());
        }
    }

    public void filter(){
        System.out.println("Age=");
        String ageStr = this.scanner.nextLine();
        int age;
        try{
            age = Integer.parseInt(ageStr);
        }
        catch (RuntimeException exception){
            System.out.println("The age needs to be an integer number!\n");
            return;
        }
        try{
            IAquaAnimal[] animals = controller.filterByAge(age);
            for(IAquaAnimal animal : animals) {
                if(animal != null)
                    System.out.println(animal);
                else
                    break;
            }
        }
        catch (RuntimeException error) {
            System.out.println(error.getMessage());
        }
    }

    public void displayAll(){
        IAquaAnimal[] animals = controller.getAll();
        if(animals.length == 0)
            System.out.println("The aquarium is empty!\n");
        else if(animals[0] == null)
            System.out.println("The aquarium is empty!\n");
        else for(IAquaAnimal animal:animals){
            if(animal != null)
                System.out.println(animal);
            else{
                System.out.println("\n");
                break;
            }
        }
    }

    public void populate(){
        try {
            controller.add(1, "Nemo", 13, "fish");
            controller.add(2, "Sabrina", 10, "turtle");
            controller.add(3, "Dory", 15, "fish");
            controller.add(4, "Bob", 7, "turtle");
        }
        catch (RuntimeException error){
            System.out.println(error.getMessage());
        }
    }

    public void testAquarium(){
        this.populate();
        System.out.println("The fish in the aquarium:\n");
        this.displayAll();
        IAquaAnimal[] animals = controller.filterByAge(12);
        System.out.println("The animals greater than 12 months:\n");
        for(IAquaAnimal animal:animals){
            if(animal != null)
                System.out.println(animal);
        }
        System.out.println("\n");
        controller.update(3, "Ben", 27, "fish");
        System.out.println("We updated 3 - Ben - 27 - fish\n");
        this.displayAll();
        controller.remove(3, "Dory", 15, "fish");
        System.out.println("We removed 3:\n");
        this.displayAll();
    }

    public void printMenu(){
        System.out.println("Welcome to the aquarium!\n");
        System.out.println("1. Add an animal!\n");
        System.out.println("2. Remove an animal!\n");
        System.out.println("3. Update an animal!\n");
        System.out.println("4. View all animals!\n");
        System.out.println("5. Filter all animals by age!\n");
        System.out.println("6. Populate aquarium!\n");
        System.out.println("0. Exit!\n");
    }

    public void run(){
        while(true){
            printMenu();
            try {
                int choice = Integer.parseInt(this.scanner.nextLine());
                if(choice == 1)
                    this.add();
                else if(choice == 2)
                    this.remove();
                else if(choice == 3)
                    this.update();
                else if (choice == 4)
                    this.displayAll();
                else if(choice == 5)
                    this.filter();
                else if(choice == 6)
                    this.populate();
                else if(choice == 0)
                    break;
                else
                    System.out.println("Choice must be in the specified interval!\n");
            }
            catch (RuntimeException error){
                System.out.println("Choice must be in the specified interval!\n");
            }
        }
    }

}
