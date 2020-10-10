package Model;

public class Fish implements IAquaAnimal{
    int ID;
    int age; //in months
    String name;

    public Fish(int ID, String name, int age) {
        this.ID = ID;
        this.name = name;
        this.age = age;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public boolean checkAgeIsGreaterThan(int age) {
        return this.age > age;
    }

    @Override
    public boolean areEqual(IAquaAnimal aquaAnimal) {
        Fish fish1 = (Fish)this;
        if(aquaAnimal instanceof Fish) {
            Fish fish2 = (Fish) aquaAnimal;
            return fish1.ID == fish2.ID;
        }
        else {
            Turtle turtle2 = (Turtle) aquaAnimal;
            return fish1.ID == turtle2.getID();
        }
    }

    @Override
    public String toString() {
        return "Fish{" +
                "ID=" + ID +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
