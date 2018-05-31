import java.util.*;

public class Table {
    private List<Card> cardsOnTable;
    Iterator<Card> it;
    //pozostałe pola

    Table(){
        cardsOnTable = new ArrayList<>();
        it = cardsOnTable.iterator();
        //pozodtałe
    }

    public void add(Card card){
        cardsOnTable.add(card);
    }

    // sprawdza, czy nie jest tak, że wszystkie są równe:
    public boolean isEveryEqual(int option){
        //for(Iterator<Card> it = cardsOnTable.iterator(); it.hasNext();){
        for(it = cardsOnTable.iterator(); it.hasNext();){
            if (!it.next().equalsAccordingTo(it.next(), option)) return false;
            return true;
        }
        return true;
    }

    public int getIndexOfWinningCard(int option){
        Comparator <Card> cardCompar = chooseComparator(option); 
        if(!isEveryEqual(option)){ //sprawdza czy nie są wszystkie równe;
            Card maks = cardsOnTable
                .stream()
                .max(cardCompar)
                .orElseThrow(NoSuchElementException::new); //exc will never take place but without nie działa;
            
            return cardsOnTable.indexOf(maks);
        }
        return -1; //or throw new NoSuchElementException
    }


    public static Comparator<Card> chooseComparator(int option){
        Comparator <Card> comp;
        switch(option){
            case 1:
                comp = Comparator.comparing(Card :: getParametr1);
                break;
            case 2:
                comp = Comparator.comparing(Card :: getParametr2);
                break;
            default:
                comp = Comparator.comparing(Card :: getParametr3);
        }
        return comp;                
    }


    //for tests only:
    public static void main(String[] args) throws NoSuchElementException {
        Card ford = new Card("Ford", 80, 400);
        Card opel = new Card("Opel", 180, 450);
        Card polonez = new Card("Polonez", 280, 80);
        //List<Card> lista = new ArrayList<>(); //jakieś cardsOnTable
        Table lista = new Table();
        lista.add(ford);
        lista.add(opel);
        lista.add(polonez);

        System.out.println(lista.isEveryEqual(1));
        System.out.println(lista.getIndexOfWinningCard(1));
    }

}
    