import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, int expected) {}

        TestCase[] tests = {
                new TestCase("successes", 6),
                new TestCase("aeiaeia", 3)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.maxFreqSum(test.in);
            assert Objects.equals(test.expected, actual) : "maxFreqSum('%s') = %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public int maxFreqSum(String s) {
        int[] freq = new int[26];
        int maxVowel = 0;
        int maxConsonant = 0;
        for (char letter : s.toCharArray()) {
            int idx = letter - 'a';
            switch (idx) {
            case 0, 4, 8, 14, 20: {
                maxVowel = Math.max(maxVowel, ++freq[idx]);
                break;
            }
            default:
                maxConsonant = Math.max(maxConsonant, ++freq[idx]);
            }
        }
        return maxVowel + maxConsonant;
    }

}