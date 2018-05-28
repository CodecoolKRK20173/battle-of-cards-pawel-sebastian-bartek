public class Card implements Comparable{

    Ranks rank;
    String suit;

    Card(String rank, String suit){
        this.rank = Ranks.valueOf(rank);
        this.suit = Suits.valueOf(suit);
    }

}
