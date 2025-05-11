import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, boolean expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 2, 6, 4, 1 }, false),
                new TestCase(new int[] { 1, 2, 34, 3, 4, 5, 7, 23, 12 }, true)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.threeConsecutiveOdds(test.in);
            assert test.expected == actual : "threeConsecutiveOdds(%s) == %s, want %s"
                    .formatted(Arrays.toString(test.in), actual, test.expected);
        }
    }

    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        for (int num : arr) {
            if (num % 2 == 0) {
                count = 0;
            } else {
                if (++count == 3) {
                    return true;
                }
            }
        }
        return false;
    }

}