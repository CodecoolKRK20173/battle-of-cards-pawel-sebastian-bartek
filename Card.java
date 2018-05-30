import java.lang.*;
public class Card implements ArbitraryComparable<Card> {

    private String name;
    private int parameter1;
    private int parameter2;
    private int parameter3;


    public Card(String n, int p1, int p2) {
        this.name = n;
        this.parameter1 = p1;
        this.parameter2 = p2;
        this.parameter3 = p1 * p2;
    }

    public String getName() {
        return name;
    }

    public int getParameter1() {
        return parameter1;
    }

    public int getParameter2() {
        return parameter2;
    }

    public int getParameter3() {
        return parameter3;
    }

    public int getParameter(int parametrNumber) {
        switch(parametrNumber) {
            case 1:
            return getParameter1();

            case 2:
            return getParameter2();

            default:
            return getParameter3();
        }
    }

    public int compareAccordingTo(Card that, int option){
        switch(option){
            case 1:
            return compare(this.parameter1, that.parameter1);

            case 2:
            return compare(this.parameter2, that.parameter2);

            default:
            return compare(this.parameter3,that.parameter3);
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
        card = card + "|(1) " + parameter1 + "     |\n";
        card = card + "|               |\n";
        card = card + "|(2) " + parameter2 + "     |\n";
        card = card + "|               |\n";
        card = card + "|(3) " + parameter3 + "     |\n\n";
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
