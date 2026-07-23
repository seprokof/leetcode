import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 3, 4, 5, 2 }, 12),
                new TestCase(new int[] { 1, 5, 4, 5 }, 16),
                new TestCase(new int[] { 3, 7 }, 12)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.maxProduct(test.in);
            assert test.expected == actual : "maxProduct(%s) == %s, want %s".formatted(Arrays.toString(test.in), actual,
                    test.expected);
        }
    }

    public int maxProduct(int[] nums) {
        int max1 = 0;
        int max2 = 0;
        for (int num : nums) {
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }
        }
        return (max1 - 1) * (max2 - 1);
    }

}