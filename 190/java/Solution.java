class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in, int expected) {}

        TestCase[] tests = {
                new TestCase(Integer.parseUnsignedInt("00000010100101000001111010011100", 2), Integer.parseUnsignedInt("00111001011110000010100101000000", 2)),
                new TestCase(Integer.parseUnsignedInt("11111111111111111111111111111101", 2), Integer.parseUnsignedInt("10111111111111111111111111111111", 2))
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.reverseBits(test.in);
            assert test.expected == actual : "reverseBits(%s) == %s, want %s".formatted(test.in, actual, test.expected);
        }
    }

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        // return Integer.reverse(n);
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int lsb = n & 1;
            result = (result << 1) | lsb;
            n = n >>> 1;
        }
        return result;
    }

}