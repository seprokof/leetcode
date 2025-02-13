import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, int expected) {}
        
        TestCase[] tests = {
                new TestCase(new int[] { 2, 11, 10, 1, 3 }, 10, 2),
                new TestCase(new int[] { 1, 1, 2, 4, 9 }, 20, 4)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minOperations(test.in1, test.in2);
            assert test.expected == actual : "minOperations(%s, %s) == %s, want %s".formatted(Arrays.toString(test.in1),
                    test.in2, actual, test.expected);
        }
    }

    public int minOperations(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int n : nums) {
            if (n < k) {
                queue.offer(n);
            }
        }
        int i = 0;
        while (!queue.isEmpty()) {
            i++;
            Integer x = queue.poll();
            Integer y = queue.poll();
            if (y == null) {
                break;
            }
            Long next = x * 2L + y;
            if (next < k) {
                queue.offer(next.intValue());
            }
        }
        return i;
    }

}