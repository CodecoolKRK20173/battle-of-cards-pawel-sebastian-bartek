import java.util.*;

public class Table {
    private Player[] players;
    private Card[] cardsOnTable;
    private ArrayList<Integer> listOfComparedParameters = new ArrayList<Integer>();

    Table(int numberOfPlayers) {
        this.players = new Player[numberOfPlayers];
        this.cardsOnTable = new Card[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            int playerNumber = i + 1;
            String name = getPlayerName(playerNumber);
            players[i] = new Player(name, numberOfPlayers, i);

        }
    }

    public String getPlayerName(int playerNumber) {
        String name;
        System.out.print("Please enter name of player " + playerNumber + ": ");
        Scanner reader = new Scanner(System.in);
        name = reader.next();
        return name;
    }

    public void getCardsFromPlayers(int numberOfPlayers, int parameterToCompare) {
        for (int i = 0; i < numberOfPlayers; i++) {
            cardsOnTable[i] = players[i].getTopCard();
            listOfComparedParameters.add(players[i].getTopCard().getParameter(parameterToCompare));
        }
    }

    public int getIndexOfWinningCard(int parameterToCompare) {
        int value = 0;
        int cardIndex = 0;
        for (int i = 0; i < cardsOnTable.length; i++) {
            int valueOfCard = cardsOnTable[i].getParameter(parameterToCompare);
            if (valueOfCard > value) {
                value = valueOfCard;
                cardIndex = i;
            }
        }
        return cardIndex;
    }

    public void clearListOfComparedParameters() {
        listOfComparedParameters.clear();
    }

    public Player[] getPlayers() {
        return players;
    }

    public Card[] getCardsOnTable() {
        return cardsOnTable;
    }
}
