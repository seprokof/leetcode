import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}
        
        TestCase[] tests = {
                new TestCase(new int[] { 3, 2, 1 }, 1),
                new TestCase(new int[] { 1, 2 }, 2),
                new TestCase(new int[] { 2, 2, 3, 1 }, 1)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.thirdMax(test.in);
            assert test.expected == actual : "thirdMax(%s) == %s, want %s".formatted(Arrays.toString(test.in), actual,
                    test.expected);
        }
    }

    public int thirdMax(int[] nums) {
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for (int n : nums) {
            queue.offer(n);
        }
        Integer max = queue.peek();
        for (int i = 0; i < 2 && !queue.isEmpty(); i++) {
            Integer current = queue.poll();
            while (current.equals(queue.peek())) {
                queue.poll();
            }
        }
        Integer thirdMax = queue.poll();
        return thirdMax == null ? max : thirdMax;
    }

}