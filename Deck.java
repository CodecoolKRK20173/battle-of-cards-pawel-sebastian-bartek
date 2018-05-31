import java.util.*;

public class Deck {
    private ArrayList<Card> cards;

    Deck() {
        cards = new ArrayList<Card>();
        cards.add(new Card("Nazwa1", 1, 20));
        cards.add(new Card("Nazwa2", 2, 11));
        cards.add(new Card("Nazwa3", 3, 4));
        cards.add(new Card("Nazwa4", 4, 18));
        cards.add(new Card("Nazwa5", 5, 7));
        cards.add(new Card("Nazwa6", 6, 5));
        cards.add(new Card("Nazwa7", 7, 34));
        cards.add(new Card("Nazwa8", 8, 28));
        cards.add(new Card("Nazwa9", 9, 2));

        Collections.shuffle(cards);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
}
