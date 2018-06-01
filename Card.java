import java.lang.*;

public class Card implements ArbitraryComparable<Card> {

    private String name;
    private int maxSpeed;
    private int horsePower;
    private int overAll;


    Card(String n, int p1, int p2) {
        this.name = n;
        this.maxSpeed = p1;
        this.horsePower = p2;
        this.overAll = p1 * p2;
    }

    public String getName() {
        return name;
    }

    public int getParameter1() {
        return maxSpeed;
    }

    public int getParameter2() {
        return horsePower;
    }

    public int getParameter3() {
        return overAll;
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
            return compare(this.maxSpeed, that.maxSpeed);

            case 2:
            return compare(this.horsePower, that.horsePower);

            default:
            return compare(this.overAll,that.overAll);
        }
    }

    private static int compare (int a, int b){
        if (a>b) return 1;
        if (a<b) return -1;
        else return 0;
    }

    public String center(String s) {
        int width = 24;
        int padSize = width - s.length();
        int padStart = s.length() + padSize / 2;
        s = String.format("%" + padStart + "s", s);
        s = String.format("%-" + width  + "s", s);
        return s;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        String line = new String(new char[26]).replace('\0', '-');

        builder.append(center(line) + "\n");
        builder.append("|" + center(name) + "|" + "\n");
        builder.append(center(line + "\n"));
        builder.append("|" + center("1) MaxSpeed:  " + String.format("%3s", Integer.toString(maxSpeed))) + "|" + "\n");
        builder.append(center(line + "\n"));
        builder.append("|" + center("2) HorsePower:" + String.format("%3s", Integer.toString(horsePower))) + "|" + "\n");
        builder.append(center(line + "\n"));
        builder.append("|" + center("3) OverAll:   " + String.format("%3s", Integer.toString(overAll))) + "|" + "\n");
        builder.append(center(line));

        String card = builder.toString();

        return card;
    }
}
