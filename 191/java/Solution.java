class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in, int expected) {}

        TestCase[] tests = {
                new TestCase(Integer.parseUnsignedInt("1011", 2), 3),
                new TestCase(Integer.parseUnsignedInt("10000000", 2), 1),
                new TestCase(Integer.parseUnsignedInt("1111111111111111111111111111101", 2), 30)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.hammingWeight(test.in);
            assert test.expected == actual : "hammingWeight(%s) == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public int hammingWeight(int n) {
        // return Integer.bitCount(n);
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += n & 1;
            n = n >>> 1;
        }
        return result;
    }

}