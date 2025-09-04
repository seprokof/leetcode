class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in1, int in2, int in3, int expected) {}

        TestCase[] tests = {
                new TestCase(2, 7, 4, 1),
                new TestCase(2, 5, 6, 2),
                new TestCase(1, 5, 3, 0)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.findClosest(test.in1, test.in2, test.in3);
            assert test.expected == actual : "findClosest(%s, %s, %s) = %s, want %s".formatted(test.in1, test.in2,
                    test.in3, actual, test.expected);
        }
    }

    public int findClosest(int x, int y, int z) {
        int distX = Math.abs(z - x);
        int distY = Math.abs(z - y);
        return distX == distY ? 0 : (distX < distY ? 1 : 2);
    }

}