import java.util.*;

public class Table {
    private Player[] players;
    private Card[] cardsOnTable;
    private int[] listOfComparedParameters;

    public Table(int numberOfPlayers) {
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

    public HashSet<Integer> isWar(int indexOfHighestCard, int parameterToCompare) {
        HashSet<Integer> indexesOfPlayersOnWar = new HashSet<Integer>();
        int highestValue = cardsOnTable[indexOfHighestCard].getParameter(parameterToCompare);
        int[] copyOfComparedParameters = Arrays.copyOf(listOfComparedParameters, listOfComparedParameters.length);
        Arrays.sort(copyOfComparedParameters);
        if(copyOfComparedParameters[copyOfComparedParameters.length-1] != copyOfComparedParameters[copyOfComparedParameters.length-2]){
            indexesOfPlayersOnWar.add(indexOfHighestCard);
            return indexesOfPlayersOnWar;
        }
        System.out.println(Arrays.toString(copyOfComparedParameters));
        return indexesOfPlayersOnWar;

    }

    public Player[] getPlayers() {
        return players;
    }

    public Card[] getCardsOnTable() {
        return cardsOnTable;
    }
}
