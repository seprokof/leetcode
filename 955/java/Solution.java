import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new String[] { "ca", "bb", "ac" }, 1),
                new TestCase(new String[] { "xc", "yb", "za" }, 0),
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
        StringBuilder[] sbs = new StringBuilder[strs.length];
        for (int i = 0; i < sbs.length; i++) {
            sbs[i] = new StringBuilder();
        }
        for (int i = 0; i < strs[0].length(); i++) {
            int size = sbs[0].length();
            for (int j = 0; j < strs.length; j++) {
                sbs[j].append(strs[j].charAt(i));
                if (j > 0) {
                    if (sbs[j - 1].compareTo(sbs[j]) > 0) {
                        for (; j >= 0; j--) {
                            sbs[j].setLength(size);
                        }
                        break;
                    }
                }
            }
        }
        return strs[0].length() - sbs[0].length();
    }

}