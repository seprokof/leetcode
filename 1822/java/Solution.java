import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { -1, -2, -3, -4, 3, 2, 1 }, 1),
                new TestCase(new int[] { 1, 5, 0, 2, -3 }, 0),
                new TestCase(new int[] { -1, 1, -1, 1, -1 }, -1)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.arraySign(test.in);
            assert test.expected == actual : "arraySign(%s) = %s, want %s".formatted(Arrays.toString(test.in), actual,
                    test.expected);
        }
    }

    public int arraySign(int[] nums) {
        int negative = 0;
        for (int num : nums) {
            if (num == 0) {
                return 0;
            } else if (num < 0) {
                negative++;
            }
        }
        return negative % 2 == 0 ? 1 : -1;
    }

}