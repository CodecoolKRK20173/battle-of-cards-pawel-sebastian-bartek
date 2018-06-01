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
    public ArrayList<Integer> getIndexesOfPlayersInGame(int numberOfPlayers) {
        ArrayList<Integer> playersInGame = new ArrayList<Integer>();
        for(int i = 0; i < numberOfPlayers; i++){
            playersInGame.add(i);
        }
        return playersInGame;
    }

    public void getCardsFromPlayers(ArrayList<Integer> indexes, int parameterToCompare) {
        for (int i = 0; i < players.length; i++) {
            if(this.isIndex(i, indexes)) {
                cardsOnTable[i] = players[i].getTopCard();
                Card card = cardsOnTable[i];
                listOfComparedParameters[i] = card.getParameter(parameterToCompare);
            }
            else {
                listOfComparedParameters[i] = 0;
            }
        }
    }
    public boolean isIndex(int index, ArrayList<Integer> indexes) {
        for(int number: indexes) {
            if(index == number) {
                return true;
            }
        }
        return false;
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

    public void moveAllCardsToCardsToBeCollected(ArrayList<Integer> indexes) {
        for (int index: indexes) {
            cardsToBeCollected.add(cardsOnTable[index]);
        }

    }

    public void clearTable() {
        cardsToBeCollected.clear();
    }

    public void showPlayersCards(ArrayList<Integer> indexes) {
        for (int index: indexes) {
            players[index].showTopCard();
            Common.sleep(500);
        }
    }

    public void showPlayersOnWar(ArrayList<Integer> indexes) {
        System.out.println("Players on war:");
        for (int index: indexes) {
            System.out.println(players[index].getName());
        }
    }
    public void showCards(ArrayList<Integer> indexes){
        StringBuilder builder = new StringBuilder();
        String line = new String(new char[26]).replace('\0', '-');

        for(int i = 0; i < 10; i++){
            for(int index: indexes){
                Card card = cardsOnTable[index];
                if(i == 0){
                    builder.append(card.center(players[index].getName()) + " ");
                }
                else if(i == 1){
                    builder.append(card.center(line) + " ");
                }
                else if(i == 2){
                    builder.append("|" + card.center(card.getName()) + "|" + " ");
                }
                else if(i == 3){
                    builder.append(card.center(line) + " ");
                }
                else if(i == 4){
                    builder.append("|" + card.center("1) Speed:       " + String.format("%3s", Integer.toString(card.getParameter1()))) + "|" + " ");
                }
                else if(i == 5){
                    builder.append(card.center(line) + " ");
                }
                else if(i == 6){
                    builder.append("|" + card.center("2) Mass:        " + String.format("%3s", Integer.toString(card.getParameter2()))) + "|" + " ");
                }
                else if(i == 7){
                    builder.append(card.center(line) + " ");
                }
                else if(i == 8){
                    builder.append("|" + card.center("3) Momentum:    " + String.format("%3s", Integer.toString(card.getParameter3()))) + "|" + " ");
                }
                else if(i == 9){
                    builder.append(card.center(line) + " ");
                }
            }
            builder.append("\n");
        }
        System.out.println(builder.toString());
    }
}
