import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 3, 5, 2, 4, 8, 2, 2 }, 1),
                new TestCase(new int[] { 3 }, 3)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minMaxGame(test.in);
            assert test.expected == actual : "minMaxGame(%s) = %s, want %s".formatted(Arrays.toString(test.in), actual,
                    test.expected);
        }
    }

    public int minMaxGame(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] newNums = new int[nums.length / 2];
        for (int i = 0; i < nums.length; i += 2) {
            int j = i / 2;
            if (j % 2 == 0) {
                newNums[j] = Math.min(nums[i], nums[i + 1]);
            } else {
                newNums[j] = Math.max(nums[i], nums[i + 1]);
            }
        }
        return minMaxGame(newNums);
    }

}