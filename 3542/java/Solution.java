import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 0, 2 }, 1),
                new TestCase(new int[] { 3, 1, 2, 1 }, 3),
                new TestCase(new int[] { 1, 2, 1, 2, 1, 2 }, 4)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minOperations(test.in);
            assert test.expected == actual : "minOperations(%s) = %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public int minOperations(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int result = 0;
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() > num) {
                stack.pop();
            }
            if (num == 0) {
                continue;
            }
            if (stack.isEmpty() || stack.peek() < num) {
                stack.push(num);
                result++;
            }
        }
        return result;
    }

}