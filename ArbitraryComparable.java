//public interface ArbitraryComparable<T extends Card> extends Comparable<T>{
//public interface ArbitraryComparable <T> extends Comparable<T>{
public interface ArbitraryComparable <T>{
    int compareAccordingTo(T obj, int option);
    

}