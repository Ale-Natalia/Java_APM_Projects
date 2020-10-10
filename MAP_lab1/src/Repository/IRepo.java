package Repository;
import Model.IAquaAnimal;

public interface IRepo {
    void addElement(IAquaAnimal element) throws MyException;
    void removeElement(IAquaAnimal element) throws MyException;
    void updateElement(IAquaAnimal element) throws MyException;

    IAquaAnimal[] getEntities();
    int getLength();
    IAquaAnimal[] filterByAge(int age);
}
