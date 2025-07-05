import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 2, 2, 3, 4 }, 2),
                new TestCase(new int[] { 1, 2, 2, 3, 3, 3 }, 3),
                new TestCase(new int[] { 2, 2, 2, 3, 3 }, -1)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.findLucky(Arrays.copyOf(test.in, test.in.length));
            assert test.expected == actual : "findLucky(%s) == %s, want %s".formatted(Arrays.toString(test.in), actual,
                    test.expected);
        }
    }

    public int findLucky(int[] arr) {
        int[] freq = new int[501];
        for (int val : arr) {
            freq[val]++;
        }
        for (int i = freq.length - 1; i > 0; i--) {
            if (freq[i] == i) {
                return i;
            }
        }
        return -1;
    }

}