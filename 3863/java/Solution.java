class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, int expected) {}

        TestCase[] tests = {
                new TestCase("dog", 1),
                new TestCase("card", 2),
                new TestCase("gf", -1)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minOperations(test.in);
            assert test.expected == actual : "minOperations('%s') == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public int minOperations(String s) {
        boolean sorted = true;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(i - 1)) {
                sorted = false;
                break;
            }
        }
        if (sorted) {
            return 0;
        }
        if (s.length() == 2) {
            return -1;
        }
        int min = s.charAt(0);
        int max = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            min = Math.min(min, ch);
            max = Math.max(max, ch);
        }
        if (s.charAt(0) == min || s.charAt(s.length() - 1) == max) {
            return 1;
        }
        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i) == min || s.charAt(i) == max) {
                return 2;
            }
        }
        return 3;
    }

}