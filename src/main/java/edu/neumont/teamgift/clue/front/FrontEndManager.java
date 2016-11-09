package main.java.edu.neumont.teamgift.clue.front;

public class FrontEndManager {

    private static FrontEndManager myInstance;

    public FrontEndManager() {
        myInstance = this;
    }

    public static FrontEndManager getInstance() {
        return myInstance;
    }

}
