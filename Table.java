import java.util.*;

public class Table {
    private Player[] players;
    private Card[] cardsOnTable;
    private int[] listOfComparedParameters;
    private ArrayList<Card> cardsToBeCollected = new ArrayList<Card>();

    Table(int numberOfPlayers) {
        this.players = new Player[numberOfPlayers];
        this.cardsOnTable = new Card[numberOfPlayers];
        this.listOfComparedParameters = new int[numberOfPlayers];
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
            Card card = cardsOnTable[i];
            listOfComparedParameters[i] = card.getParameter(parameterToCompare);
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

    public boolean isWar(int parameterToCompare) {
        int[] copyOfComparedParameters = Arrays.copyOf(listOfComparedParameters, listOfComparedParameters.length);
        Arrays.sort(copyOfComparedParameters);
        if(copyOfComparedParameters[copyOfComparedParameters.length-1] != copyOfComparedParameters[copyOfComparedParameters.length-2]){
            return false;
        }
        else {
            return true;
        }
    }

    public Player[] getPlayers() {
        return players;
    }

    public Card[] getCardsOnTable() {
        return cardsOnTable;
    }

    public ArrayList<Card> getCardsToBeCollected() {
        return cardsToBeCollected;
    }

    public int getHighestParamaterValue() {
        int[] copyOfComparedParameters = Arrays.copyOf(listOfComparedParameters, listOfComparedParameters.length);
        Arrays.sort(copyOfComparedParameters);
        int highestParameter = copyOfComparedParameters[copyOfComparedParameters.length-1];
        return highestParameter;
    }

    public ArrayList<Integer> getIndexesOfPlayersOnWar(int highestParameter) {
        ArrayList<Integer> indexesOfPlayersOnWar = new ArrayList<Integer>();
        for(int i = 0; i < listOfComparedParameters.length; i++) {
            if (listOfComparedParameters[i] == highestParameter)
                indexesOfPlayersOnWar.add(i);
        }
        return indexesOfPlayersOnWar;
    }

    public void moveCardsOnWarToCardsToBeCollected(int highestParameter) {
        for (int index : getIndexesOfPlayersOnWar(highestParameter)) {
            cardsToBeCollected.add(cardsOnTable[index]);
        }
    }

    public void moveAllCardsToCardsToBeCollected() {
        cardsToBeCollected = new ArrayList<Card>(Arrays.asList(cardsOnTable));
    }

    public void clearTable() {
        cardsToBeCollected.clear();
    }

    public void showPlayersCards() {
        for (int i = 0; i < players.length; i++) {
            players[i].showTopCard();
            Common.sleep(500);
        }
    }
}
