import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, boolean expected) {}

        TestCase[] tests = {
                new TestCase("leetcoder", true),
                new TestCase("bbcd", false)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.doesAliceWin(test.in);
            assert Objects.equals(test.expected, actual) : "doesAliceWin('%s') = %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public boolean doesAliceWin(String s) {
        for (char letter : s.toCharArray()) {
            switch (letter) {
            case 'a', 'e', 'i', 'o', 'u':
                return true;
            }
        }
        return false;
    }

}