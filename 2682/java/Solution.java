import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in1, int in2, int[] expected) {}

        TestCase[] tests = {
                new TestCase(5, 2, new int[] { 4, 5 }),
                new TestCase(4, 4, new int[] { 2, 3, 4 })
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[] actual = s.circularGameLosers(test.in1, test.in2);
            assert Arrays.equals(test.expected, actual) : "circularGameLosers(%s, %s) == %s, want %s"
                    .formatted(test.in1, test.in2, Arrays.toString(actual), Arrays.toString(test.expected));
        }
    }

    public int[] circularGameLosers(int n, int k) {
        int[] balls = new int[n];
        balls[0] = 1;
        int current = 0;
        int i = 1;
        while (true) {
            current = (current + i * k) % n;
            if (++balls[current] > 1) {
                break;
            }
            i++;
        }
        int[] result = new int[n - i];
        int m = 0;
        for (int j = 0; j < balls.length && m < n - i; j++) {
            if (balls[j] == 0) {
                result[m++] = j + 1;
            }
        }
        return result;
    }

}