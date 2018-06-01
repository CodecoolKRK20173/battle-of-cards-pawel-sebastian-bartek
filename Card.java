import java.lang.*;

public class Card {
    private String name;
    private int speed;
    private int mass;
    private int momentum;

    Card(String n, int p1, int p2) {
        this.name = n;
        this.speed = p1;
        this.mass = p2;
        this.momentum = p1 * p2;
    }

    public String getName() {
        return name;
    }

    public int getParameter1() {
        return speed;
    }

    public int getParameter2() {
        return mass;
    }

    public int getParameter3() {
        return momentum;
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
        builder.append("|" + center("(1) speed:    " + String.format("%3s", Integer.toString(speed))) + "|" + "\n");
        builder.append(center(line + "\n"));
        builder.append("|" + center("(2) mass:     " + String.format("%3s", Integer.toString(mass))) + "|" + "\n");
        builder.append(center(line + "\n"));
        builder.append("|" + center("(3) momentum: " + String.format("%3s", Integer.toString(momentum))) + "|" + "\n");
        builder.append(center(line));

        String card = builder.toString();

        return card;
    }
}
