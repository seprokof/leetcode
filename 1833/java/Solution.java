import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 3, 2, 4, 1 }, 7, 4),
                new TestCase(new int[] { 10, 6, 8, 7, 7, 8 }, 5, 0),
                new TestCase(new int[] { 1, 6, 3, 1, 2, 5 }, 20, 6)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.maxIceCream(test.in1, test.in2);
            assert test.expected == actual : "maxIceCream(%s, %s) == %s, want %s".formatted(Arrays.toString(test.in1),
                    test.in2, actual, test.expected);
        }
    }

    public int maxIceCream(int[] costs, int coins) {
        int[] frequency = new int[100001];
        for (int cost : costs) {
            frequency[cost]++;
        }
        int result = 0;
        for (int i = 1; i < frequency.length && coins >= i; i++) {
            int count = Math.min(frequency[i], coins / i);
            result += count;
            coins -= count * i;
        }
        return result;
    }

}