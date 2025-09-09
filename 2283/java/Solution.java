class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, boolean expected) {}

        TestCase[] tests = {
                new TestCase("1210", true),
                new TestCase("030", false)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.digitCount(test.in);
            assert test.expected == actual : "digitCount('%s') = %s, want %s".formatted(test.in, actual, test.expected);
        }
    }

    public boolean digitCount(String num) {
        int[] freq = new int[10];
        for (char ch : num.toCharArray()) {
            freq[ch - '0']++;
        }
        for (int i = 0; i < num.length(); i++) {
            if (freq[i] != num.charAt(i) - '0') {
                return false;
            }
        }
        return true;
    }

}