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

    public boolean isGameOver() {
        for (int i = 0; i < table.getPlayers().length; i++) {
            if (table.getPlayers()[i].getPile().getMyCards().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public void showWinners() {
        ArrayList<Integer> numberOfCardsInPiles = new ArrayList<Integer>();
        ArrayList<Player> winners = new ArrayList<Player>();
        for (int i = 0; i < table.getPlayers().length; i++) {
            numberOfCardsInPiles.add(table.getPlayers()[i].getPile().getMyCards().size());
        }
        int maxCards = Collections.max(numberOfCardsInPiles);

        for (int i = 0; i < table.getPlayers().length; i++) {
            if (table.getPlayers()[i].getPile().getMyCards().size() == maxCards)
                winners.add(table.getPlayers()[i]);
        }
        System.out.println("And the winner is...");
        for (Player winner: winners)
            System.out.println(winner.getName() + " (" + winner.getNumberOfCards() + ")");
    }

    public void warHandler(int parameterToCompare) {
        while (table.isWar(parameterToCompare)) {
            System.out.println("So it's war!");
            table.moveAllCardsToCardsToBeCollected();
            int highestCardValue = table.getHighestParamaterValue();
            ArrayList<Integer> playersOnWar = table.getIndexesOfPlayersOnWar(highestCardValue);
            int numberOfPlayersOnWar = playersOnWar.size();
            int nextPlayer = (int)(Math.random() * numberOfPlayersOnWar);
            table.getPlayers()[nextPlayer].showTopCard();
            parameterToCompare = table.getPlayers()[nextPlayer].getParameterToCompare();
            for (int i = 0; i < playersOnWar.size(); i++) {
                if (playersOnWar.contains(i)) {
                    table.getPlayers()[i].showTopCard();
                    Common.sleep(500);
                }
            }
        }
    }

    public void startGame() {
        int numberOfPlayers = getNumberOfPlayers();
        this.table = new Table(numberOfPlayers);
        int nextPlayer = (int)(Math.random() * numberOfPlayers);

        while (!isGameOver()) {
            for (int i = 0; i < table.getPlayers().length; i++)
                System.out.println(table.getPlayers()[i].getNumberOfCards());
            table.getPlayers()[nextPlayer].showTopCard();
            int parameterToCompare = table.getPlayers()[nextPlayer].getParameterToCompare();
            table.showPlayersCards();
            table.getCardsFromPlayers(numberOfPlayers, parameterToCompare);
            Common.pressAnyKey();
            int indexOfHighestCard = table.getIndexOfWinningCard(parameterToCompare);
            if (table.isWar(parameterToCompare)) {
                warHandler(parameterToCompare);
            }
            else {
                table.moveAllCardsToCardsToBeCollected();
                table.getPlayers()[indexOfHighestCard].addCardsToPile(table.getCardsToBeCollected());
                table.clearTable();
                nextPlayer = indexOfHighestCard;

            }
        }
        showWinners();
    }
}
