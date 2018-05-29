import java.lang.*;

public class Card {

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

    public int compareTo(Card other) {
        return Double.compare(parametr1, other.parametr1);
    }

    public String toString() {
        String card = "";
        card = card + "_________________\n";
        card = card + "|    " + name + "     |\n";
        card = card + "|               |\n";
        card = card + "";
        return card;
    }

}
