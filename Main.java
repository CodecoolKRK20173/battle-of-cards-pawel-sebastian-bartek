import java.util.*;

public class Main {
    public static void main(String[] args) {
        clearScreen();
        new Game().gameHandler();
    }

    private static void clearScreen(){
        //Runtime.getRuntime().exec("clear"); // nie działa, więc wytrychem go:
        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
    }
}
