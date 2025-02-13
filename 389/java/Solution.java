class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in1, String in2, char expected) {}
        
        TestCase[] tests = {
                new TestCase("abcd", "abcde", 'e'),
                new TestCase("", "y", 'y')
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            char actual = s.findTheDifference(test.in1, test.in2);
            assert test.expected == actual : "findTheDifference('%s', '%s') == '%s', want '%s'".formatted(test.in1,
                    test.in2, actual, test.expected);
        }
    }

    public char findTheDifference(String s, String t) {
        int[] letterCount = new int[26];
        for (char ch : t.toCharArray()) {
            letterCount[ch - 'a']++;
        }
        for (char ch : s.toCharArray()) {
            letterCount[ch - 'a']--;
        }
        for (int i = 0; i < letterCount.length; i++) {
            if (letterCount[i] == 1) {
                return (char) ('a' + i);
            }
        }
        return 'a' - 1;
    }

}