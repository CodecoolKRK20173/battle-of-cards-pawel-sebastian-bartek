import java.util.*;

public class Pile {
    private static final Deck deck = new Deck(); // czy final zależo, czy pozbywamy się kart rozdając;
    private static final int numberOfCards = deck.size(); //może być final
    private ArrayList<Card> myCards = new ArrayList<Card>();
    

    
    Pile(){
        myCards = null;
    }
        
    public ArrayList<Card> getPile() {
        return myCards;
    }

    public void add(Card card){
        myCards.add(card);
    }

    public static void main(String[] args) {
        // jak się deck rozdaje na paile
    }
}
