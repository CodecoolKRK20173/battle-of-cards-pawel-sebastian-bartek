import java.util.*;

public class Deck { //implements Iterable<Card>{
    private List<Card> cards = new ArrayList<Card>();
    Iterator <Card> it;


    public Deck() {
        it = cards.iterator();
        cards.add(new Card("Nazwa1", 1, 20));
        cards.add(new Card("Nazwa2", 2, 20));
        cards.add(new Card("Nazwa3", 3, 4));
        cards.add(new Card("Nazwa4", 4, 20));
        cards.add(new Card("Nazwa5", 5, 20));
        cards.add(new Card("Nazwa6", 6, 20));
        cards.add(new Card("Nazwa7", 7, 20));
        cards.add(new Card("Nazwa8", 8, 20));
        cards.add(new Card("Nazwa9", 9, 20));

        Collections.shuffle(cards);
    }

    // do we need it?
    public List<Card> getCards() {
        return cards;
    }

    public Card getCard(int index){
        return cards.get(index);
    }

    public void removeCard(int index){ // is not the same as remove(index)?
        cards.remove(index);
    }

    public void removeCard(Card card){
        cards.remove(card);
    }

    public int size(){
        return this.cards.size();
    }
    
   public Card next(){
        return it.next();
    }
    
   public boolean hasNext() {
        return it.hasNext();
   }   
    
    
    public static void main(String[] args) {
        Deck test = new Deck();
        //System.out.println(test.size());
        List<Deque<Card>> table = new ArrayList<Deque<Card>>(); // lista paili
        Deque<Card> pail1 = new ArrayDeque<>();
        Deque<Card> pail2 = new ArrayDeque<>();
        table.add(pail1);
        table.add(pail2);

        int i = test.size()-1;
        while (test.hasNext()){
        //while (i >= 0) {
            for (Deque<Card> pail : table) {
                if(i>=0){
                    pail.add(test.getCard(i));
                    System.out.println("before rem: " + i);
                    test.removeCard(i);
                    if(i >=0) i--;
                }
            }
        }
        
        /*//ConcurrentModificationException
        while (test.hasNext()){
                for (Deque<Card> pail : table) {
                    if(test.hasNext()){
                        pail.add(test.next());
                        System.out.println("bef rem " +test.size());
                        test.removeCard(test.next());
                        System.out.println("aft rem " + test.size());
                        System.out.println("has next:" +test.hasNext());
                    }   
                }
            }*/


        System.out.println(pail1);
        System.out.println(pail2);
        

        //pail1.add(test.next());

        //int i = 0;

        }
        
    }


