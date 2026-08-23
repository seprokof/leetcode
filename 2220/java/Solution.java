class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in1, int in2, int expected) {}

        TestCase[] tests = {
                new TestCase(10, 7, 3),
                new TestCase(3, 4, 3)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minBitFlips(test.in1, test.in2);
            assert test.expected == actual : "minBitFlips(%s, %s) == %s, want %s".formatted(test.in1, test.in2, actual,
                    test.expected);
        }
    }

    public int minBitFlips(int start, int goal) {
        int xor = start ^ goal;
        int result = 0;
        while (xor > 0) {
            if (xor % 2 == 1) {
                result++;
            }
            xor /= 2;
        }
        return result;
    }

}