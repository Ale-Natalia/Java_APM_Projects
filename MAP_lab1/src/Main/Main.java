package Main;

import Controller.Controller;
import Repository.Repo;
import View.View;

public class Main {
    public static void main(String[] args){
        Repo repo = new Repo(15);
        Controller controller = new Controller(repo);
        View view = new View(controller);
        view.testAquarium();
        //view.run();
    }
}
