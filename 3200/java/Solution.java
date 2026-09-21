class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in1, int in2, int expected) {}

        TestCase[] tests = {
                new TestCase(2, 4, 3),
                new TestCase(2, 1, 2),
                new TestCase(1, 1, 1),
                new TestCase(10, 1, 2)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.maxHeightOfTriangle(test.in1, test.in2);
            assert test.expected == actual : "maxHeightOfTriangle(%s, %s) = %s, want %s".formatted(test.in1, test.in2,
                    actual, test.expected);
        }
    }

    public int maxHeightOfTriangle(int red, int blue) {
        return Math.max(getHeight(red, blue), getHeight(blue, red));
    }

    private static int getHeight(int odd, int even) {
        for (int i = 1;; i++) {
            if (i % 2 == 0) {
                even -= i;
                if (even < 0) {
                    return i - 1;
                }
            } else {
                odd -= i;
                if (odd < 0) {
                    return i - 1;
                }
            }
        }
    }

}