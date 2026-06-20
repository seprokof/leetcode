class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, boolean expected) {}

        TestCase[] tests = {
                new TestCase("1 box has 3 blue 4 red 6 green and 12 yellow marbles", true),
                new TestCase("hello world 5 x 5", false),
                new TestCase("sunset is at 7 51 pm overnight lows will be in the low 50 and 60 s", false)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.areNumbersAscending(test.in);
            assert test.expected == actual : "areNumbersAscending('%s') == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public boolean areNumbersAscending(String s) {
        int prevNum = -1;
        int lastDigitIndex = -1;
        int currNum = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                if (lastDigitIndex + 1 == i) {
                    currNum = currNum * 10 + (ch - '0');
                } else {
                    currNum = ch - '0';
                }
                lastDigitIndex = i;
            } else if (currNum > 0) {
                if (currNum <= prevNum) {
                    return false;
                } else {
                    prevNum = currNum;
                    currNum = 0;
                }
            }
        }
        if (currNum > 0) {
            return currNum > prevNum;
        }
        return true;
    }

}