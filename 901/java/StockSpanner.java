import java.util.ArrayList;
import java.util.List;

class StockSpanner {

    private final List<int[]> list;

    public StockSpanner() {
        this.list = new ArrayList<>();
    }

    public int next(int price) {
        int span = 1;
        int idx = list.size() - 1;
        while (idx > -1) {
            int[] current = list.get(idx);
            if (current[0] > price) {
                break;
            }
            span += current[1];
            idx -= current[1];
        }
        list.add(new int[] { price, span });
        return span;
    }

}
