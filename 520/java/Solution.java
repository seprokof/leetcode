class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, boolean expected) {}

        TestCase[] tests = {
                new TestCase("USA", true),
                new TestCase("FlaG", false)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.detectCapitalUse(test.in);
            assert test.expected == actual : "detectCapitalUse(%s) == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public boolean detectCapitalUse(String word) {
        if (word.length() == 1) {
            return true;
        }
        boolean isUpper = Character.isUpperCase(word.charAt(1));
        if (isUpper && Character.isLowerCase(word.charAt(0))) {
            return false;
        }
        for (int i = 2; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i)) != isUpper) {
                return false;
            }
        }
        return true;
    }

}