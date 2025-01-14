import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int[] expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 5, 10, -5 }, new int[] { 5, 10 }),
                new TestCase(new int[] { 8, -8 }, new int[] { }),
                new TestCase(new int[] { 10, 2, -5 }, new int[] { 10 })
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[] actual = s.asteroidCollision(test.in);
            assert Arrays.equals(test.expected, actual) : "asteroidCollision(%s) == %s, want %s"
                    .formatted(Arrays.toString(test.in), Arrays.toString(actual), Arrays.toString(test.expected));
        }
    }

    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>(asteroids.length);
        stack.push(asteroids[0]);
        for (int i = 1; i < asteroids.length; i++) {
            if (stack.isEmpty() || asteroids[i] > 0 || (stack.peek() * asteroids[i]) > 0) {
                stack.push(asteroids[i]);
            } else {
                boolean add = false;
                while (!stack.isEmpty() && (stack.peek() * asteroids[i]) < 0) {
                    if (stack.peek() < Math.abs(asteroids[i])) {
                        stack.pop();
                        add = true;
                    } else if (stack.peek() == Math.abs(asteroids[i])) {
                        stack.pop();
                        add = false;
                        break;
                    } else {
                        add = false;
                        break;
                    }
                }
                if (add) {
                    stack.push(asteroids[i]);
                }
            }
        }
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }

}