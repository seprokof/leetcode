import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 2, 2, 3, 1, 4 }, 4),
                new TestCase(new int[] { 1, 2, 3, 4, 5 }, 5)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.maxFrequencyElements(test.in);
            assert test.expected == actual : "maxFrequencyElements(%s) = %s, want %s"
                    .formatted(Arrays.toString(test.in), actual, test.expected);
        }
    }

    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, ++freq[num]);
        }
        int count = 0;
        for (int f : freq) {
            if (f == max) {
                count++;
            }
        }
        return max * count;
    }

}