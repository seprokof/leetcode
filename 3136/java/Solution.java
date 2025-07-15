import java.util.Set;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, boolean expected) {}

        TestCase[] tests = {
                new TestCase("234Adas", true),
                new TestCase("b3", false),
                new TestCase("a3$e", false)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.isValid(test.in);
            assert test.expected == actual : "isValid('%s') == %s, want %s".formatted(test.in, actual, test.expected);
        }
    }

    private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u');

    public boolean isValid(String word) {
        if (word.length() < 3) {
            return false;
        }
        boolean hasVowel = false;
        boolean hasConsonant = false;
        for (char ch : word.toCharArray()) {
            if (Character.isLetter(ch)) {
                if (VOWELS.contains(Character.toLowerCase(ch))) {
                    hasVowel = true;
                } else {
                    hasConsonant = true;
                }
            } else if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return hasVowel && hasConsonant;
    }

}