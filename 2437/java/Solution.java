class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, int expected) {}

        TestCase[] tests = {
                new TestCase("?5:00", 2),
                new TestCase("0?:0?", 100),
                new TestCase("??:??", 1440)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.countTime(test.in);
            assert test.expected == actual : "countTime('%s') = %s, want %s".formatted(test.in, actual, test.expected);
        }
    }

    public int countTime(String time) {
        int h = 0;
        if (time.charAt(0) == '?') {
            if (time.charAt(1) == '?') {
                h = 24;
            } else if (time.charAt(1) < '4') {
                h = 3;
            } else {
                h = 2;
            }
        } else {
            if (time.charAt(1) == '?') {
                if (time.charAt(0) < '2') {
                    h = 10;
                } else {
                    h = 4;
                }
            } else {
                h = 1;
            }
        }
        int m = 0;
        if (time.charAt(3) == '?') {
            if (time.charAt(4) == '?') {
                m = 60;
            } else {
                m = 6;
            }
        } else {
            if (time.charAt(4) == '?') {
                m = 10;
            } else {
                m = 1;
            }
        }
        return h * m;
    }

}