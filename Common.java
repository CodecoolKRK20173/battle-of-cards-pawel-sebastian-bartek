import java.util.*;
import java.util.concurrent.TimeUnit;

public class Common {
    public static int getChoice(int min, int max, boolean showMenu) {
        Scanner reader = new Scanner(System.in);
        boolean stop = false;
        int option = 0;
        while(!stop) {
            reader = new Scanner(System.in);
            try {
                option = reader.nextInt();
                if(option >= min && option <= max) {
                    stop = true;
                }
                else if (showMenu) {
                    System.out.println("\nThere is no such option!");
                    Game.showMenu();
                }
                else {
                    System.out.print("\nNumber is out of range! Try again: ");
                }
            }
            catch(InputMismatchException e) {
                System.out.println("\nWrong input. Try again!");
                if (showMenu)
                    Game.showMenu();
            }
        }
        return option;
    }

    public static void sleep(int milliseconds) {
        try {
          TimeUnit.MILLISECONDS.sleep(milliseconds);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void pressAnyKey() {
        System.out.println("Press Enter key to continue...");
        try {
            System.in.read();
        }
        catch(Exception e) {}
    }

}
