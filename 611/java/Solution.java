import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 2, 2, 3, 4 }, 3),
                new TestCase(new int[] { 4, 2, 3, 4 }, 4)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.triangleNumber(test.in);
            assert test.expected == actual : "triangleNumber(%s) = %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == 0) {
                continue;
            }
            int k = i + 2;
            for (int j = i + 1; j < nums.length - 1; j++) {
                int sum = nums[i] + nums[j];
                while (k < nums.length && sum > nums[k]) {
                    k++;
                }
                result += (k - j - 1);
            }
        }
        return result;
    }

}