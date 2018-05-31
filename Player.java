import java.util.*;

class Player {
    private Pile myPile;
    private String name;

    Player(String name, int numberOfPlayers, int startingPoint) {
        this.myPile = new Pile(numberOfPlayers, startingPoint);
        this.name = name;
    }

    public void showTopCard() {
        Card topCard = myPile.getPile().get(0);
        System.out.println(topCard);
    }

    public Card getTopCard() {
        Card topCard = myPile.getPile().get(0);
        myPile.getPile().remove(0);
        return topCard;
    }

    public int getParameterToCompare() {
        showTopCard();
        System.out.print("Choose the parameter to compare: ");
        int parameterToCompare = Common.getChoice(1, 3, false);
        return parameterToCompare;
    }

    public void addCardsToPile(ArrayList<Card> cardsToAdd) {
        myPile.getPile().addAll(cardsToAdd);
    }

    public String getName() {
        return this.name;
    }
}
