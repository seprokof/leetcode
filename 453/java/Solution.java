import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 2, 3 }, 3),
                new TestCase(new int[] { 1, 1, 1 }, 0)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minMoves(test.in);
            assert test.expected == actual : "minMoves(%s) == %s, want %s".formatted(Arrays.toString(test.in), actual,
                    test.expected);
        }
    }

    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
        }
        int result = 0;
        for (int num : nums) {
            result += num - min;
        }
        return result;
    }

}