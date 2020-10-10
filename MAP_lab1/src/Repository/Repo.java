package Repository;

import Model.IAquaAnimal;

public class Repo implements IRepo {
    public IAquaAnimal[] entities;
    int length;

    public Repo(int size){
        this.length = 0;
        this.entities = new IAquaAnimal[size];
    }

    @Override
    public void addElement(IAquaAnimal element) throws MyException {
        int index = 0;
        if (this.length > this.entities.length)
            throw new MyException("There's no space left in the aquarium!\n");
        for(IAquaAnimal el : entities){
            if (el == null)
                    break;
            if (el.areEqual(element))
                throw new MyException("Animal already exists!\n");
            index++;
        }
        entities[index] = element;
        this.length++;
    }

    @Override
    public void removeElement(IAquaAnimal element) throws MyException {
        boolean startRemoving = false;
        for(int index = 0; index < length; index++){
            IAquaAnimal el = this.entities[index];
            if (el == null)
                break;
            if(startRemoving) {
                this.entities[index] = this.entities[index+1];
            }
            else if (el.areEqual(element)) {
                startRemoving = true;
                if(index < length - 1)
                    this.entities[index] = this.entities[index+1];
            }
        }
        if (!startRemoving){
            throw new MyException("Animal does not exist!\n");
        }
    }

    @Override
    public void updateElement(IAquaAnimal element) throws MyException {
        boolean found = false;
        for(int index = 0; index < length; index++){
            IAquaAnimal el = this.entities[index];
            if (el == null)
                break;
            if (el.areEqual(element)) {
                found = true;
                this.entities[index] = element;
                break;
            }
        }
        if (!found){
            throw new MyException("Animal does not exist!\n");
        }
    }

    public IAquaAnimal[] getEntities() {
        return entities;
    }

    public int getLength() {
        return length;
    }

    @Override
    public IAquaAnimal[] filterByAge(int age) {
        IAquaAnimal[] filteredAnimals = new IAquaAnimal[this.length];
        int numberOfAnimals = 0;
        for (IAquaAnimal el : this.entities){
            if(el == null)
                break;
            if(el.checkAgeIsGreaterThan(age)){
                filteredAnimals[numberOfAnimals] = el;
                numberOfAnimals++;
            }
        }
        return filteredAnimals;
    }
}
