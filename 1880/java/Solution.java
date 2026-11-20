class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in1, String in2, String in3, boolean expected) {}

        TestCase[] tests = {
                new TestCase("acb", "cba", "cdb", true),
                new TestCase("aaa", "a", "aab", false)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.isSumEqual(test.in1, test.in2, test.in3);
            assert test.expected == actual : "isSumEqual('%s', '%s', '%s') == %s, want %s".formatted(test.in1, test.in2,
                    test.in3, actual, test.expected);
        }
    }

    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        return (numericalValue(firstWord) + numericalValue(secondWord)) == numericalValue(targetWord);
    }

    private static int numericalValue(String str) {
        int result = 0;
        for (int i = str.length() - 1, multiplier = 1; i >= 0; i--, multiplier *= 10) {
            result += (str.charAt(i) - 'a') * multiplier;
        }
        return result;
    }

}