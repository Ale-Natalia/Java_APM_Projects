package Model;

public interface IAquaAnimal {

    String getName();
    int getAge();
    int getID();
    boolean checkAgeIsGreaterThan(int age);
    boolean areEqual(IAquaAnimal aquaAnimal);
    String toString();
}
