import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int[] in2, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 3, 2 }, new int[] { 4, 3, 1, 5, 2 }, 2),
                new TestCase(new int[] { 5, 5, 5 }, new int[] { 2, 4, 2, 7 }, 4)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minimumBoxes(test.in1, test.in2);
            assert test.expected == actual : "minimumBoxes(%s, %s) = %s, want %s".formatted(Arrays.toString(test.in1),
                    Arrays.toString(test.in2), actual, test.expected);
        }
    }

    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int i = capacity.length - 1;
        int available = capacity[i];
        int result = 1;
        for (int num : apple) {
            while (num > available) {
                result++;
                available += capacity[--i];
            }
            available -= num;
        }
        return result;
    }

}