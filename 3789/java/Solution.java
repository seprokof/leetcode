class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in1, int in2, int in3, int in4, int in5, long expected) {}

        TestCase[] tests = {
                new TestCase(3, 2, 1, 3, 2, 3),
                new TestCase(5, 4, 15, 2, 3, 22),
                new TestCase(5, 4, 15, 0, 0, 0)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            long actual = s.minimumCost(test.in1, test.in2, test.in3, test.in4, test.in5);
            assert test.expected == actual : "minimumCost(%s, %s, %s, %s, %s) = %s, want %s".formatted(test.in1,
                    test.in2, test.in3, test.in4, test.in5, actual, test.expected);
        }
    }

    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        if (cost1 + cost2 <= costBoth) {
            return 1L * cost1 * need1 + 1L * cost2 * need2;
        }
        long result = 1L * costBoth * Math.min(need1, need2);
        if (need1 < need2) {
            result += 1L * Math.min(cost2, costBoth) * (need2 - need1);
        } else if (need1 > need2) {
            result += 1L * Math.min(cost1, costBoth) * (need1 - need2);
        }
        return result;
    }

}