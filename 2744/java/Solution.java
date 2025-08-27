import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new String[] { "cd", "ac", "dc", "ca", "zz" }, 2),
                new TestCase(new String[] { "ab", "ba", "cc" }, 1),
                new TestCase(new String[] { "aa", "ab" }, 0)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.maximumNumberOfStringPairs(test.in);
            assert test.expected == actual : "maximumNumberOfStringPairs(%s) = %s, want %s"
                    .formatted(Arrays.toString(test.in), actual, test.expected);
        }
    }

    public int maximumNumberOfStringPairs(String[] words) {
        boolean[] isUsed = new boolean[words.length];
        int result = 0;
        for (int i = 0; i < words.length - 1; i++) {
            if (isUsed[i]) {
                continue;
            }
            for (int j = i + 1; j < words.length; j++) {
                if (isUsed[j]) {
                    continue;
                }
                if (words[i].charAt(0) == words[j].charAt(1) && words[i].charAt(1) == words[j].charAt(0)) {
                    isUsed[j] = true;
                    result++;
                }
            }
        }
        return result;
    }

}