class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in1, int in2, int expected) {}

        TestCase[] tests = {
                new TestCase(13, 6, 15),
                new TestCase(10, 3, 13)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.maxBottlesDrunk(test.in1, test.in2);
            assert test.expected == actual : "maxBottlesDrunk(%s, %s) = %s, want %s".formatted(test.in1, test.in2,
                    actual, test.expected);
        }
    }

    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int result = numBottles;
        while (numBottles >= numExchange) {
            result++;
            numBottles = numBottles - numExchange + 1;
            numExchange++;
        }
        return result;
    }

}