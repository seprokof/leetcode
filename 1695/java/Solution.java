import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 4, 2, 4, 5, 6 }, 17),
                new TestCase(new int[] { 5, 2, 1, 2, 5, 2, 1, 2, 5 }, 8)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.maximumUniqueSubarray(test.in);
            assert test.expected == actual : "maximumUniqueSubarray(%s) = %s, want %s"
                    .formatted(Arrays.toString(test.in), actual, test.expected);
        }
    }

    public int maximumUniqueSubarray(int[] nums) {
        int l = 0;
        int sum = 0;
        int max = 0;
        boolean[] contains = new boolean[10001];
        for (int r = 0; r < nums.length; r++) {
            if (contains[nums[r]]) {
                max = Math.max(max, sum);
                while (nums[l] != nums[r]) {
                    sum -= nums[l];
                    contains[nums[l]] = false;
                    l++;
                }
                l++;
            } else {
                sum += nums[r];
                contains[nums[r]] = true;
            }
        }
        return Math.max(max, sum);
    }

}