class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, int expected) {}

        TestCase[] tests = {
                new TestCase("abcabc", 10),
                new TestCase("aaacb", 3),
                new TestCase("abc", 1)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.numberOfSubstrings(test.in);
            assert test.expected == actual : "numberOfSubstrings(%s) == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public int numberOfSubstrings(String s) {
        int[] idxs = new int[] { -1, -1, -1 };
        int result = 0;
        for (int i = 0; i <= s.length() - 3; i++) {
            label: for (int j = 0; j < idxs.length; j++) {
                if (idxs[j] < i) {
                    for (int k = i; k < s.length(); k++) {
                        if (s.charAt(k) - 'a' == j) {
                            idxs[j] = k;
                            continue label;
                        }
                    }
                    return result;
                }
            }
            int endIdx = Math.max(idxs[0], Math.max(idxs[1], idxs[2]));
            result += s.length() - endIdx;
        }
        return result;
    }

}