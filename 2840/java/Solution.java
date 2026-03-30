class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in1, String in2, boolean expected) {}

        TestCase[] tests = {
                new TestCase("abcdba", "cabdab", true),
                new TestCase("abe", "bea", false)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.checkStrings(test.in1, test.in2);
            assert test.expected == actual : "checkStrings('%s', '%s') = %s, want %s".formatted(test.in1, test.in2,
                    actual, test.expected);
        }
    }

    public boolean checkStrings(String s1, String s2) {
        int[] freqOdd = new int[26];
        int[] freqEven = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            if (i % 2 == 0) {
                freqEven[s1.charAt(i) - 'a']++;
                freqEven[s2.charAt(i) - 'a']--;
            } else {
                freqOdd[s1.charAt(i) - 'a']++;
                freqOdd[s2.charAt(i) - 'a']--;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (freqOdd[i] != 0 || freqEven[i] != 0) {
                return false;
            }
        }
        return true;
    }

}