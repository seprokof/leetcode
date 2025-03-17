import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, boolean expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 3, 2, 3, 2, 2, 2 }, true),
                new TestCase(new int[] { 1, 2, 3, 4 }, false)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.divideArray(test.in);
            assert test.expected == actual : "divideArray(%s) == %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public boolean divideArray(int[] nums) {
        int[] arr = new int[501];
        for (int n : nums) {
            arr[n]++;
        }
        for (int a : arr) {
            if (a % 2 != 0) {
                return false;
            }
        }
        return true;
    }

}