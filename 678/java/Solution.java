class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, boolean expected) {}

        TestCase[] tests = {
                new TestCase("()", true),
                new TestCase("(*)", true),
                new TestCase("(*))", true),
                new TestCase("(", false)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.checkValidString(test.in);
            assert test.expected == actual : "checkValidString('%s') == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public boolean checkValidString(String s) {
        int min = 0;
        int max = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                min++;
                max++;
            } else if (ch == '*') {
                min--;
                max++;
            } else {
                min--;
                max--;
            }
            if (max < 0) {
                return false;
            }
            min = Math.max(min, 0);
        }
        return min == 0;
    }

}