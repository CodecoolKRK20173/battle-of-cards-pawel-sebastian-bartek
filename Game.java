import java.util.*;
import java.lang.Math;

public class Game {
    Table table;

    public static void showMenu() {
        List<String> menuOptions = new ArrayList<String>();
        menuOptions.add("(1) Start game");
        menuOptions.add("(0) Exit\n");
        for (String element : menuOptions)
            System.out.println(element);
        System.out.print("Choose your option: ");
    }

    public int getNumberOfPlayers() {
        int numberOfPlayers;
        System.out.print("How many players? ");
        numberOfPlayers = Common.getChoice(2, 4, false);
        return numberOfPlayers;
    }

    public void gameHandler() {
        boolean isRunning = true;

        while (isRunning) {
            showMenu();
            int option = Common.getChoice(0, 1, true);
            switch (option) {
                case 1:
                    startGame();
                    break;
                case 0:
                    isRunning = false;
                    System.out.println("\nGoodbye.\n");
                    break;
            }
        }
    }

    public void startGame() {
        boolean isRunning = true;
        int numberOfPlayers = getNumberOfPlayers();
        this.table = new Table(numberOfPlayers);
        int firstPlayer = (int)(Math.random() * numberOfPlayers);
        int parameterToCompare = table.getPlayers()[firstPlayer].getParameterToCompare();

        for (int i = 0; i < numberOfPlayers; i++) {
            table.getPlayers()[i].showTopCard();
        }

        table.getCardsFromPlayers(numberOfPlayers, parameterToCompare);



        int indexOfTaker = table.getIndexOfWinningCard(parameterToCompare);
        System.out.println(table.getCardsOnTable()[indexOfTaker]);

    }
}
