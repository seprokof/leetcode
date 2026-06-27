class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, boolean expected) {}

        TestCase[] tests = {
                new TestCase("132", true),
                new TestCase("129", false)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.isAdjacentDiffAtMostTwo(test.in);
            assert test.expected == actual : "isAdjacentDiffAtMostTwo('%s') == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public boolean isAdjacentDiffAtMostTwo(String s) {
        char prev = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (Math.abs(cur - prev) > 2) {
                return false;
            }
            prev = cur;
        }
        return true;
    }

}