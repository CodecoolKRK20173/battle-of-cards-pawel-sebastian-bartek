import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Card implements Comparable<Card> {

    Suits suit;
    Ranks rank;

    Card (Suits suit, Ranks rank){ //taking Enum-type args;
        this.suit = suit;
        this.rank = rank;
    }
    
    //alternative constructor, taking string args;
    Card(String suit, String rank){
        this.rank = Ranks.valueOf(rank);
        this.suit = Suits.valueOf(suit);
    }

    @Override
    public int compareTo(Card that) { //as far we compare only ranks(figury), not suit(kolory);
        return this.rank.compareTo(that.rank);
    }

    //according to Horstmann if want to compare, define equals() and hashCode():
    public boolean equals(Object thatObject){
        if (this == thatObject) return true;
        if (thatObject == null) return false;
        if (getClass() != thatObject.getClass()) return false;
        Card that = (Card) thatObject;
        return Objects.equals(this.rank, that.rank) && Objects.equals(this.suit, that.suit);
    }

    public int hashCode(){ 
        return Objects.hash(rank, suit); 
    }
    
    public String toString(){ //returns: (ex) QUEEN of ♠
        return String.format("%s of %s", rank, suit.getRepresentation());
    }

    //not belongs to class, just for testing class:
    public static void main(String[] args) {
        //Look how enums works:
        for(Suits suit: Suits.values()) 
            System.out.println(suit.getRepresentation());
        
        //something like deck:
        List<Card> deck = new ArrayList<>();

        //somethinh like deck constructor:
        for(Suits suit: Suits.values()) {
            for(Ranks rank: Ranks.values()) deck.add(new Card(suit, rank));
        }

        //printing deck :)
        for(Card aCard: deck) System.out.println(aCard);

        Card ace = new Card("CLUBS", "ACE"); // testing constructor raking Strings
        Card king = new Card(Suits.DIAMONDS, Ranks.KING); //testing alt. constructor
        
    }
    
}