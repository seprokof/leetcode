class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in1, int in2, int expected) {}

        TestCase[] tests = {
                new TestCase(9, 3, 13),
                new TestCase(15, 4, 19)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.numWaterBottles(test.in1, test.in2);
            assert test.expected == actual : "numWaterBottles(%s, %s) = %s, want %s".formatted(test.in1, test.in2,
                    actual, test.expected);
        }
    }

    public int numWaterBottles(int numBottles, int numExchange) {
        int result = numBottles;
        while (numBottles >= numExchange) {
            int numExchanged = numBottles / numExchange;
            result += numExchanged;
            numBottles = numExchanged + numBottles % numExchange;
        }
        return result;
    }

}