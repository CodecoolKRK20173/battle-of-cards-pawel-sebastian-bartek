import java.util.*;

public class Deck {
    private ArrayList<Card> cards;

    Deck() {
        cards = new ArrayList<Card>();
        cards.add(new Card("Nazwa1", 1, 6));
        cards.add(new Card("Nazwa2", 2, 12));
        cards.add(new Card("Nazwa3", 3, 4));
        cards.add(new Card("Nazwa4", 4, 18));
        cards.add(new Card("Nazwa5", 5, 12));
        cards.add(new Card("Nazwa6", 6, 5));
        cards.add(new Card("Nazwa7", 7, 7));
        cards.add(new Card("Nazwa8", 8, 12));
        cards.add(new Card("Nazwa9", 9, 5));

        Collections.shuffle(cards);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
}
