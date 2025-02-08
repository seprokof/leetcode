import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class NumberContainers {

    private final Map<Integer, Integer> values;
    private final Map<Integer, Queue<Integer>> indexes;

    public NumberContainers() {
        this.values = new HashMap<>();
        this.indexes = new HashMap<>();
    }

    public void change(int index, int number) {
        Integer oldValue = values.get(index);
        if (oldValue != null) {
            if (oldValue.equals(number)) {
                return;
            }
            indexes.get(oldValue).remove(index);
        }
        values.put(index, number);
        indexes.computeIfAbsent(number, ignore -> new PriorityQueue<>()).offer(index);
    }

    public int find(int number) {
        Queue<Integer> values = indexes.get(number);
        return (values == null || values.isEmpty()) ? -1 : values.peek();
    }

}
