class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in1, int in2, double expected) {}

        TestCase[] tests = {
                new TestCase(12, 30, 165D),
                new TestCase(3, 30, 75D),
                new TestCase(3, 15, 7.5D)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            double actual = s.angleClock(test.in1, test.in2);
            assert test.expected == actual : "angleClock(%s, %s) == %s, want %s".formatted(test.in1, test.in2, actual,
                    test.expected);
        }
    }

    public double angleClock(int hour, int minutes) {
        double degrees = minutes * 6 - (hour % 12 + minutes / 2.0D);
        return Math.min(degrees, 360 - degrees);
    }

}