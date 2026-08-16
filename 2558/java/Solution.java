import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, long expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 25, 64, 9, 4, 100 }, 4, 29L),
                new TestCase(new int[] { 1, 1, 1, 1 }, 4, 4L)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            long actual = s.pickGifts(test.in1, test.in2);
            assert test.expected == actual : "pickGifts(%s, %s) == %s, want %s".formatted(Arrays.toString(test.in1),
                    test.in2, actual, test.expected);
        }
    }

    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((l, r) -> r.compareTo(l));
        for (int gift : gifts) {
            queue.offer(gift);
        }
        for (int i = 0; i < k; i++) {
            int value = (int) Math.sqrt(queue.poll());
            queue.offer(value);
        }
        long result = 0L;
        for (Integer n : queue) {
            result += n;
        }
        return result;
    }

}