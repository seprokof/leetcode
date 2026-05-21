import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int[] in2, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 10, 100 }, new int[] { 1000 }, 3),
                new TestCase(new int[] { 1, 2, 3 }, new int[] { 4, 4, 4 }, 0)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.longestCommonPrefix(test.in1, test.in2);
            assert test.expected == actual : "longestCommonPrefix(%s, %s) = %s, want %s"
                    .formatted(Arrays.toString(test.in1), Arrays.toString(test.in2), actual, test.expected);
        }
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> prefixes = new HashSet<>();
        for (int val : arr1) {
            while (val > 0) {
                prefixes.add(val);
                val /= 10;
            }
        }
        int max = 0;
        for (int val : arr2) {
            while (val > 0) {
                if (prefixes.contains(val)) {
                    max = Math.max(max, val);
                }
                val /= 10;
            }
        }
        return max == 0 ? 0 : String.valueOf(max).length();
    }

}