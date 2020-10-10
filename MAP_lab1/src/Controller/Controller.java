package Controller;

import Model.Fish;
import Model.IAquaAnimal;
import Model.Turtle;
import Repository.MyException;
import Repository.Repo;

public class Controller {
    public Repo repo;

    public Controller(Repo repo) {
        this.repo = repo;
    }

    public void add(int ID, String name, int age, String type) throws MyException {
        if(type.equals("fish")){
            Fish fish = new Fish(ID, name, age);
            this.repo.addElement(fish);
        }
        else{
            Turtle turtle = new Turtle(ID, name, age);
            this.repo.addElement(turtle);
        }
    }

    public void remove(int ID, String name, int age, String type) throws MyException {
        if(type.equals("fish")){
            Fish fish = new Fish(ID, name, age);
            this.repo.removeElement(fish);
        }
        else {
            Turtle turtle = new Turtle(ID, name, age);
            this.repo.removeElement(turtle);
        }
    }

    public void update(int ID, String name, int age, String type) throws MyException {
            if(type.equals("fish")){
                Fish fish = new Fish(ID, name, age);
                this.repo.updateElement(fish);
            }
            else {
                Turtle turtle = new Turtle(ID, name, age);
                this.repo.updateElement(turtle);
            }
    }

    public IAquaAnimal[] filterByAge(int age) throws MyException {
        IAquaAnimal[] filteredList = this.repo.filterByAge(age);
        boolean empty = true;
        for (IAquaAnimal aquaAnimal : filteredList) {
            if (aquaAnimal != null) {
                empty = false;
                break;
            }
        }
        if (empty) {
            throw new MyException("There are no aqua animals  with the required age!\n");
        }
        return filteredList;
    }

    public IAquaAnimal[] getAll(){
        return repo.getEntities();
    }
}
