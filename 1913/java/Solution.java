import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 5, 6, 2, 7, 4 }, 34),
                new TestCase(new int[] { 4, 2, 5, 9, 7, 4, 8 }, 64)
        };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.maxProductDifference(test.in);
            assert test.expected == actual : "maxProductDifference(%s) = %s, want %s"
                    .formatted(Arrays.toString(test.in), actual, test.expected);
        }
    }

    public int maxProductDifference(int[] nums) {
        int max1 = 0;
        int max2 = 0;
        int min1 = 10001;
        int min2 = 10001;
        for (int num : nums) {
            if (num >= max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }
            if (num <= min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }
        return max1 * max2 - min1 * min2;
    }

}