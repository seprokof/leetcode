class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in1, int in2, int expected) {}

        TestCase[] tests = {
                new TestCase("abciiidef", 3, 3),
                new TestCase("aeiou", 2, 2),
                new TestCase("leetcode", 3, 2)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.maxVowels(test.in1, test.in2);
            assert test.expected == actual : "maxVowels('%s', %s) == %s, want %s".formatted(test.in1, test.in2, actual,
                    test.expected);
        }
    }

    public int maxVowels(String s, int k) {
        int[] vowels = new int[26];
        vowels[0] = 1;   // 'a'
        vowels[4] = 1;   // 'e' 
        vowels[8] = 1;   // 'i'
        vowels[14] = 1;  // 'o'
        vowels[20] = 1;  // 'u'

        int previousNumVowels = 0;
        for (int i = 0; i < k; i++) {
            previousNumVowels += vowels[s.charAt(i) - 'a'];
        }
        int max = previousNumVowels;
        for (int i = 1; i < s.length() - k + 1; i++) {
            previousNumVowels = previousNumVowels - vowels[s.charAt(i - 1) - 'a'] + vowels[s.charAt(i + k - 1) - 'a'];
            max = Math.max(max, previousNumVowels);
        }
        return max;
    }

}