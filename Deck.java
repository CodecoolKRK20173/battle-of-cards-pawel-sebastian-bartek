import java.util.*;

public class Deck {
    private ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<Card>();
        cards.add(new Card("Nazwa1", 1, 20));
        cards.add(new Card("Nazwa2", 2, 20));
        cards.add(new Card("Nazwa3", 3, 4));
        cards.add(new Card("Nazwa4", 4, 20));
        cards.add(new Card("Nazwa5", 5, 20));
        cards.add(new Card("Nazwa6", 6, 20));
        cards.add(new Card("Nazwa7", 7, 20));
        cards.add(new Card("Nazwa8", 8, 20));
        cards.add(new Card("Nazwa9", 9, 20));

        Collections.shuffle(cards);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
}
