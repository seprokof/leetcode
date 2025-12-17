import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 2, 2, 3, 1 }, 2),
                new TestCase(new int[] { 1, 2, 2, 3, 1, 4, 2 }, 6)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.findShortestSubArray(test.in);
            assert test.expected == actual : "findShortestSubArray(%s) = %s, want %s"
                    .formatted(Arrays.toString(test.in), actual, test.expected);
        }
    }

    public int findShortestSubArray(int[] nums) {
        int[] frequency = new int[50001];
        int maxFrequency = 0;
        int[] firstIndex = new int[50001];
        int minSubArrLen = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (++frequency[nums[i]] == 1) {
                firstIndex[nums[i]] = i + 1;
            }
            if (frequency[nums[i]] == maxFrequency) {
                minSubArrLen = Math.min(minSubArrLen, i - firstIndex[nums[i]] + 2);
            } else if (frequency[nums[i]] > maxFrequency) {
                maxFrequency = frequency[nums[i]];
                minSubArrLen = i - firstIndex[nums[i]] + 2;
            }
        }
        return minSubArrLen;
    }

}