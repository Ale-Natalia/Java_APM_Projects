package Model;

public class Turtle implements IAquaAnimal {
    int ID;
    int age; //in months
    String name;

    public Turtle(int ID, String name, int age) {
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
        Turtle turtle1 = (Turtle)this;
        if(aquaAnimal instanceof Fish) {
            Fish fish2 = (Fish) aquaAnimal;
            return turtle1.ID == fish2.getID();
        }
        else {
            Turtle turtle2 = (Turtle) aquaAnimal;
            return turtle1.ID == turtle2.getID();
        }
    }

    @Override
    public String toString() {
        return "Turtle{" +
                "ID=" + ID +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
