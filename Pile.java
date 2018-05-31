import java.util.*;

public class Pile {
    private ArrayList<Card> myCards = new ArrayList<Card>();
    private static final Deck deck = new Deck();
    private static final int numberOfCards = deck.getCards().size();

    Pile(int numberOfPlayers, int startingPoint) {
        for (int i = startingPoint; i < numberOfCards; i += numberOfPlayers) {
            if (i <= numberOfCards) {
                myCards.add(deck.getCards().get(i));
            }
        }
    }

    public ArrayList<Card> getPile() {
        return myCards;
    }
}
