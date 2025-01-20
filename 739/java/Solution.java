import java.util.Arrays;
import java.util.Stack;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int[] expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 73, 74, 75, 71, 69, 72, 76, 73 }, new int[] { 1, 1, 4, 2, 1, 1, 0, 0 }),
                new TestCase(new int[] { 30, 40, 50, 60 }, new int[] { 1, 1, 1, 0 }),
                new TestCase(new int[] { 30, 60, 90 }, new int[] { 1, 1, 0 })
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[] actual = s.dailyTemperatures(test.in);
            assert Arrays.equals(test.expected, actual) : "dailyTemperatures(%s) == %s, want %s"
                    .formatted(Arrays.toString(test.in), Arrays.toString(actual), Arrays.toString(test.expected));
        }
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                answer[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        return answer;
    }

}