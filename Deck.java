import java.util.*;

public class Deck {
    private ArrayList<Card> cards;

    Deck() {
        cards = new ArrayList<Card>();
        cards.add(new Card("Polonez", 120, 12));
        cards.add(new Card("Ford", 140, 12));
        cards.add(new Card("Opel", 145, 7));
        cards.add(new Card("VW", 135, 18));
        cards.add(new Card("Fiat", 125, 12));
        cards.add(new Card("Ferrari", 300, 5));
        cards.add(new Card("Tesla", 350, 7));
        cards.add(new Card("Mercedes", 350, 12));
        cards.add(new Card("Mazda", 310, 19));
        cards.add(new Card("Toyota", 310, 12));
        cards.add(new Card("Hyundai", 260, 13));
        cards.add(new Card("BMW", 330, 21));
        cards.add(new Card("Syrena", 4, 33));
        cards.add(new Card("Skoda", 70, 22));
        cards.add(new Card("KIA", 6, 6));
        cards.add(new Card("Mitsubishi", 170, 7));
        cards.add(new Card("Lada", 80, 12));
        cards.add(new Card("UAZ", 10, 29));
        cards.add(new Card("Honda", 310, 12));
        cards.add(new Card("Land Rover", 90, 13));
        cards.add(new Card("Jeep", 80, 33));
        cards.add(new Card("Subaru", 310, 12));
        cards.add(new Card("Warszawa", 1, 1000));
        cards.add(new Card("Motor", 360, 1));
        cards.add(new Card("Nissan", 230, 7));
        cards.add(new Card("Chevrolette", 230, 12));
        cards.add(new Card("Jaguar", 370, 29));
        cards.add(new Card("Lamborgini", 400, 12));

        Collections.shuffle(cards);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
}
