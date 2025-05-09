import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 3, 2, 2, 5, 2, 3, 7 }, 5),
                new TestCase(new int[] { 1, 2, 3, 4 }, 2),
                new TestCase(new int[] { 1, 1, 1, 1 }, 0)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.findLHS(test.in);
            assert test.expected == actual : "findLHS(%s) == %s, want %s".formatted(Arrays.toString(test.in), actual,
                    test.expected);
        }
    }

    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        int start = 0;
        int end = 1;
        while (end < nums.length) {
            int dif = nums[end] - nums[start];
            if (dif == 1) {
                max = Math.max(end - start + 1, max);
                end++;
            } else if (dif > 1) {
                start++;
            } else {
                end++;
            }
        }
        return max;
    }

}