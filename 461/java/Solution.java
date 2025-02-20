class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in1, int in2, int expected) {}
        
        TestCase[] tests = {
                new TestCase(1, 4, 2),
                new TestCase(3, 1, 1)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.hammingDistance(test.in1, test.in2);
            assert test.expected == actual : "hammingDistance(%s, %s) == %s, want %s".formatted(test.in1, test.in2,
                    actual, test.expected);
        }
    }

    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

}