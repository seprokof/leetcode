import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, int in3, int[] expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 2, 1, 3, 5, 6 }, 5, 2, new int[] { 8, 4, 6, 5, 6 }),
                new TestCase(new int[] { 1, 2 }, 3, 4, new int[] { 16, 8 })
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[] actual = s.getFinalState(Arrays.copyOf(test.in1, test.in1.length), test.in2, test.in3);
            assert Arrays.equals(test.expected, actual) : "getFinalState(%s, %s, %s) = %s, want %s".formatted(
                    Arrays.toString(test.in1), test.in2, test.in3, Arrays.toString(actual),
                    Arrays.toString(test.expected));
        }
    }

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(nums.length,
                (l, r) -> l[0] == r[0] ? l[1] - r[1] : l[0] - r[0]);
        for (int i = 0; i < nums.length; i++) {
            queue.offer(new int[] { nums[i], i });
        }
        for (int i = 0; i < k; i++) {
            int[] min = queue.poll();
            min[0] *= multiplier;
            nums[min[1]] = min[0];
            queue.offer(min);
        }
        return nums;
    }

}