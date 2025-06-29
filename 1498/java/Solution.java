import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, int expected) {}
        
        TestCase[] tests = {
                new TestCase(new int[] { 3, 5, 6, 7 }, 9, 4),
                new TestCase(new int[] { 3, 3, 6, 8 }, 10, 6),
                new TestCase(new int[] { 2, 3, 3, 4, 6, 7 }, 12, 61)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.numSubseq(Arrays.copyOf(test.in1, test.in1.length), test.in2);
            assert test.expected == actual : "numSubseq(%s, %s) == %s, want %s".formatted(Arrays.toString(test.in1),
                    test.in2, actual, test.expected);
        }
    }

    private static final int MODULO = 1_000_000_007;

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int[] power = new int[nums.length];
        power[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            power[i] = (power[i - 1] * 2) % MODULO;
        }
        int left = 0;
        int right = nums.length - 1;
        int result = 0;
        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                result = (result + power[right - left]) % MODULO;
                left++;
            } else {
                right--;
            }
        }
        return result;
    }

}