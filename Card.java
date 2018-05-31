import java.lang.*;
import java.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Comparator;
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

    public int getValuable(int option){
        switch(option){
            case 1: return parametr1;
            case 2: return parametr2;
            default: return parametr3;
        } 
    }

    public int compareAccordingTo(Card that, int option){ // don't delete, it' sused!
        //Comparator com1 = (c1, c2) -> c1.getParametr1().compareTo(c2.getParametr1());
        //Comparator com2 = (c1, c2) -> c1.getParametr2().compareTo(c2.getParametr2());
        //Comparator com3 = (c1, c2) -> c1.getParametr3().compareTo(c2.getParametr3());
        return compare(this.getValuable(option), that.getValuable(option));

    }
    //nothing common with standard library Compare() from Comparator interface;
    private static int compare (int a, int b){ //used with compareAccordingTo;
        if (a>b) return 1;
        if (a<b) return -1;
        else return 0;
    }

    //according to Horstmann if want to compare, define equals() and hashCode():
    public boolean equals(Object thatObject){
        if (this == thatObject) return true;
        if (thatObject == null) return false;
        if (getClass() != thatObject.getClass()) return false;
        Card that = (Card) thatObject;
        return this.name.equals(that.name)
                                        && this.parametr1==that.parametr1
                                        && this.parametr2==that.parametr2
                                        && this.parametr3==that.parametr3;
                                                
    }

    public int hashCode(){ 
        return Objects.hash(name,parametr1, parametr2, parametr3); 
        }

    public boolean equalsAccordingTo(Object thatObject, int option){
        Card that = (Card) thatObject;
        if(compareAccordingTo(that, option) == 0) 
            return true;
        return false;
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
    public static void main(String[] args) throws NoSuchElementException {
        Card ford = new Card("Ford", 100, 400);
        Card opel = new Card("Opel", 80,450);
        Card polonez = new Card("Poldek", 400, 80);

        System.out.println(ford);
        System.out.println(opel.compareAccordingTo(ford, 1));
        System.out.println(opel.compareAccordingTo(ford, 2));
        System.out.println(opel.compareAccordingTo(ford, 0));

        List<Card> lista = new ArrayList<>();
        lista.add(ford);
        lista.add(opel);
        lista.add(polonez);
        //System.out.println(polonez.equals(opel) + '\u26fd');

        // znajdowanie indeksu największej karty
        Comparator<Card> com1 = Comparator.comparing(Card :: getParametr1);
        Comparator<Card> com2 = Comparator.comparing(Card :: getParametr2);
        Comparator<Card> com3 = Comparator.comparing(Card :: getParametr3);

        Card maks = lista
            .stream()
            .max(com1)
            .orElseThrow(NoSuchElementException::new);
        System.out.println(lista.indexOf(maks));
            
                
        
        }
            
        
}


