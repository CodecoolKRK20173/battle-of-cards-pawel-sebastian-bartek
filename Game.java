import java.util.*;
import java.lang.Math;

public class Game {
    Player[] players;
    Table table;

    public int getChoice(int min, int max, boolean showMenu) {
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
                    showMenu();
                }
                else {
                    System.out.print("\nNumber is out of range! Try again: ");
                }
            }
            catch(InputMismatchException e) {
                System.out.println("\nWrong input. Try again!");
                if (showMenu)
                    showMenu();
            }
        }
        return option;
    }

    public void showMenu() {
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
        numberOfPlayers = getChoice(2, 4, false);
        return numberOfPlayers;
    }

    public String getPlayerName(int playerNumber) {
        String name;
        System.out.print("Please enter name of player " + playerNumber + ": ");
        Scanner reader = new Scanner(System.in);
        name = reader.next();
        return name;
    }

    public void gameHandler() {
        boolean isRunning = true;

        while (isRunning) {
            showMenu();
            int option = getChoice(0, 1, true);
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
        this.players = new Player[numberOfPlayers];
        this.table = new Table(numberOfPlayers);

        for (int i = 0; i < numberOfPlayers; i++) {
            int playerNumber = i + 1;
            String name = getPlayerName(playerNumber);
            players[i] = new Player(name, numberOfPlayers, i);
        }

        int firstPlayer = (int)(Math.random() * numberOfPlayers);

        System.out.println(players[0].getTopCard());

        // while(isRunning) {
        //     firstPlayer
        // }
    }
}
