import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in1, int[] in2, int[] in3, List<Integer> expected) {}

        TestCase[] tests = {
                new TestCase(3, new int[] { 1, 2, 3, 4, 5 }, new int[] { 5, 2, 3, 3, 3 }, List.of(1)),
                new TestCase(3, new int[] { 1, 2, 3, 4 }, new int[] { 1, 2, 1, 2 }, List.of(0)),
                new TestCase(3, new int[] { 1, 2, 3 }, new int[] { 10, 12, 11 }, List.of(0, 1, 2))
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            List<Integer> actual = s.busiestServers(test.in1, test.in2, test.in3);
            assert areSame(test.expected, actual) : "busiestServers(%s, %s, %s) == %s, want %s".formatted(test.in1,
                    Arrays.toString(test.in2), Arrays.toString(test.in3), actual, test.expected);
        }
    }

    private static boolean areSame(List<Integer> expected, List<Integer> actual) {
        return expected.size() == actual.size() && Objects.equals(new HashSet<>(expected), new HashSet<>(actual));
    }

    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        PriorityQueue<Integer> free = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            free.offer(i);
        }
        PriorityQueue<int[]> busy = new PriorityQueue<>((l, r) -> l[0] == r[0] ? l[1] - r[1] : l[0] - r[0]);
        int[] count = new int[k];
        for (int i = 0; i < arrival.length; i++) {
            while (!busy.isEmpty() && busy.peek()[0] <= arrival[i]) {
                int serverIdx = busy.poll()[1];
                free.offer(i + Math.floorMod(serverIdx - i, k));
            }
            if (!free.isEmpty()) {
                int serverIdx = free.poll() % k;
                busy.offer(new int[] { arrival[i] + load[i], serverIdx });
                count[serverIdx]++;
            }
        }
        int max = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (count[i] > max) {
                result.clear();
                max = count[i];
                result.add(i);
            } else if (count[i] == max) {
                result.add(i);
            }
        }
        return result;
    }

}