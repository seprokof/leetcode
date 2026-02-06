import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 2, 1, 5}, 2, 1),
                new TestCase(new int[] { 1, 6, 2, 9 }, 3, 2),
                new TestCase(new int[] { 4, 6 }, 2, 0)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minRemoval(Arrays.copyOf(test.in1, test.in1.length), test.in2);
            assert test.expected == actual : "minRemoval(%s, %s) = %s, want %s".formatted(Arrays.toString(test.in1),
                    test.in2, actual, test.expected);
        }
    }

    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int max = 0;
        int len = nums.length;
        int deletions = len;
        for (int min = 0; min < len; min++) {
            long lowBound = 1L * nums[min] * k;
            while (max < len && nums[max] <= lowBound) {
                max++;
            }
            deletions = Math.min(deletions, len - max + min);
        }
        return deletions;
    }

}