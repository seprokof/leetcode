import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}
        
        TestCase[] tests = {
                new TestCase(new int[] { 3, 6, 1, 0 }, 1),
                new TestCase(new int[] { 1, 2, 3, 4 }, -1),
                
                new TestCase(new int[] { 1, 0 }, 0)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.dominantIndex(test.in);
            assert test.expected == actual : "dominantIndex(%s) == %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public int dominantIndex(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max1Idx = -1;
        int max2 = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (max1 < nums[i]) {
                max2 = max1;
                max1Idx = i;
                max1 = nums[i];
            } else if (max2 < nums[i]) {
                max2 = nums[i];
            }
        }
        if (max1 >= 2 * max2) {
            return max1Idx;
        }
        return -1;
    }

}