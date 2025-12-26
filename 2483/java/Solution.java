class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, int expected) {}

        TestCase[] tests = {
                new TestCase("YYNY", 2),
                new TestCase("NNNNN", 0),
                new TestCase("YYYY", 4)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.bestClosingTime(test.in);
            assert test.expected == actual : "bestClosingTime('%s') = %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public int bestClosingTime(String customers) {
        int penalty = 0;
        int minPenaty = 0;
        int hour = -1;
        for (int i = 0; i < customers.length(); i++) {
            if (customers.charAt(i) == 'Y') {
                penalty--;
            } else {
                penalty++;
            }
            if (penalty < minPenaty) {
                minPenaty = penalty;
                hour = i;
            }
        }
        return hour + 1;
    }

}