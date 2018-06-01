import java.util.*;

public class Deck {
    private ArrayList<Card> cards;

    Deck() {
        cards = new ArrayList<Card>();
        cards.add(new Card("Lambo", 320, 350));
        cards.add(new Card("Ferrari", 320, 350));
        cards.add(new Card("Poldek", 160, 75));
        cards.add(new Card("Syrenka", 120, 65));
        cards.add(new Card("Tarpan", 120, 75));
        cards.add(new Card("Volvo", 200, 150));
        cards.add(new Card("Porshe", 320, 300));
        cards.add(new Card("Audi", 260, 240));
        cards.add(new Card("Ford", 220, 160));
        cards.add(new Card("Fiat", 160, 90));
        cards.add(new Card("Peugot", 180, 120));
        cards.add(new Card("VolksWagen", 200, 140));
        cards.add(new Card("BMW", 260, 220));
        cards.add(new Card("Mercedes", 260, 250));
        cards.add(new Card("Citroen", 220, 150));
        cards.add(new Card("GMC", 230, 300));
        cards.add(new Card("Acura", 260, 260));
        cards.add(new Card("Seat", 240, 160));

        Collections.shuffle(cards);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
}
