public interface ArbitraryComparable<T extends Card> extends Comparable<T>{
    int compareAccordingTo(T card);

}