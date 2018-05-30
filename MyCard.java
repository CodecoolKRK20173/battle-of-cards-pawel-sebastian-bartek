import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MyCard implements ArbitraryComparable<Card> {

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

    public int ArbitraryCompareTo(Ra)

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