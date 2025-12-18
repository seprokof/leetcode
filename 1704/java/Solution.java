class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, boolean expected) {}

        TestCase[] tests = {
                new TestCase("book", true),
                new TestCase("textbook", false)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.halvesAreAlike(test.in);
            assert test.expected == actual : "halvesAreAlike('%s') = %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    private static final String VOWELS = "aeiouAEIOU";

    public boolean halvesAreAlike(String s) {
        char[] letters = s.toCharArray();
        int count = 0;
        for (int left = 0, right = s.length() - 1; left < right; left++, right--) {
            if (VOWELS.indexOf(letters[left]) > -1) {
                count++;
            }
            if (VOWELS.indexOf(letters[right]) > -1) {
                count--;
            }
        }
        return count == 0;
    }

}