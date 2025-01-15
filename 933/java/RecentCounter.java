import java.util.ArrayDeque;
import java.util.Deque;

class RecentCounter {

    private final Deque<Integer> requests;

    public RecentCounter() {
        this.requests = new ArrayDeque<>();
    }

    public int ping(int t) {
        requests.push(t);
        while (!requests.isEmpty()) {
            Integer time = requests.peekLast();
            if (t - 3000 > time) {
                requests.pollLast();
            } else {
                break;
            }
        }
        return requests.size();
    }

}
