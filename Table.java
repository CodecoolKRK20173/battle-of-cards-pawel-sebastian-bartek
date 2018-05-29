import java.util.*;

public class Table {
    private Map<Integer, Card> table = new HashMap<>();

    public Table(int numberOfPlayers) {
        for (int i = 0; i < numberOfPlayers; i++)
            table.put(i, null);
    }
}
