class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, boolean expected) {}

        TestCase[] tests = {
                new TestCase("thequickbrownfoxjumpsoverthelazydog", true),
                new TestCase("leetcode", false)
        };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.checkIfPangram(test.in);
            assert test.expected == actual : "checkIfPangram(%s) = %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public boolean checkIfPangram(String sentence) {
        for (char letter = 'a'; letter <= 'z'; letter++) {
            if (sentence.indexOf(letter) < 0) {
                return false;
            }
        }
        return true;
    }

}