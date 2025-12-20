import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new String[] { "cba", "daf", "ghi" }, 1),
                new TestCase(new String[] { "a", "b" }, 0),
                new TestCase(new String[] { "zyx", "wvu", "tsr" }, 3)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minDeletionSize(test.in);
            assert test.expected == actual : "minDeletionSize(%s) = %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public int minDeletionSize(String[] strs) {
        int result = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) < strs[j - 1].charAt(i)) {
                    result++;
                    break;
                }
            }
        }
        return result;
    }

}