import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, int[] expected) {}
        
        TestCase[] tests = {
                new TestCase(new int[] { 2, 1, 3, 3 }, 2, new int[] { 3, 3 }),
                new TestCase(new int[] { -1, -2, 3, 4 }, 3, new int[] { -1, 3, 4 }),
                new TestCase(new int[] { 3, 4, 3, 3 }, 2, new int[] { 3, 4 })
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[] actual = s.maxSubsequence(test.in1, test.in2);
            assert Arrays.equals(test.expected, actual) : "maxSubsequence(%s, %s) == %s, want %s".formatted(
                    Arrays.toString(test.in1), test.in2, Arrays.toString(actual), Arrays.toString(test.expected));
        }
    }

    public int[] maxSubsequence(int[] nums, int k) {
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);
        int threshold = sorted[sorted.length - k];
        int thresholdCnt = 0;
        for (int i = sorted.length - k; i < sorted.length; i++) {
            if (sorted[i] == threshold) {
                thresholdCnt++;
            }
        }
        int[] result = new int[k];
        int resultIdx = 0;
        for (int num : nums) {
            if (num > threshold) {
                result[resultIdx++] = num;
            } else if (num == threshold && thresholdCnt > 0) {
                result[resultIdx++] = num;
                thresholdCnt--;
            }
            if (resultIdx == k) {
                return result;
            }
        }
        return null;
    }

}