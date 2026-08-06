class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in1, int in2, int expected) {}

        TestCase[] tests = {
                new TestCase(10, 2, 10),
                new TestCase(15, 3, 16)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.smallestNumber(test.in1, test.in2);
            assert test.expected == actual : "smallestNumber(%s, %s) == %s, want %s".formatted(test.in1, test.in2,
                    actual, test.expected);
        }
    }

    public int smallestNumber(int n, int t) {
        for (int i = 0; i < 10; i++, n++) {
            if (isProductDivisible(n, t)) {
                break;
            }
        }
        return n;
    }

    private static boolean isProductDivisible(int val, int t) {
        int product = 1;
        while (val != 0) {
            int digit = val % 10;
            if (digit == 0 || digit == t) {
                return true;
            }
            product *= digit;
            val /= 10;
        }
        return product % t == 0;
    }

}