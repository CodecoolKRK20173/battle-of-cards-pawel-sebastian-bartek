import java.lang.*;
public class Card implements ArbitraryComparable<Card> {

    private String name;
    private int parametr1;
    private int parametr2;
    private int parametr3;


    public Card(String n, int p1, int p2) {
        this.name = n;
        this.parametr1 = p1;
        this.parametr2 = p2;
        this.parametr3 = p1 * p2;
    }

    public String getName() {
        return name;
    }

    public int getParametr1() {
        return parametr1;
    }

    public int getParametr2() {
        return parametr2;
    }

    public int getParametr3() {
        return parametr3;
    }

    public int compareAccordingTo(Card that, int option){
        switch(option){
            case 1:
            return compare(this.parametr1, that.parametr1);

            case 2:
            return compare(this.parametr2, that.parametr2);
            
            default:
            return compare(this.parametr3,that.parametr3);
        }
    }

    private static int compare (int a, int b){
        if (a>b) return 1;
        if (a<b) return -1;
        else return 0;
    }

    public String toString() {
        String card = "";
        card = card + "_________________\n";
        card = card + "|    " + name + "     |\n";
        card = card + "|               |\n";
        card = card + "";
        return card;
    }

    //for tests only:
    public static void main(String[] args) {
        Card ford = new Card("Ford", 100, 400);
        Card opel = new Card("Opel", 80,450);

        System.out.println(ford);
        opel.compareAccordingTo(ford, 1);
        opel.compareAccordingTo(ford, 2);
        opel.compareAccordingTo(ford, 0);
        
    }

}
