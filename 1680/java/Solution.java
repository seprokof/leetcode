class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in, int expected) {}

        TestCase[] tests = {
                new TestCase(1, 1),
                new TestCase(3, 27),
                new TestCase(12, 505379714)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.concatenatedBinary(test.in);
            assert test.expected == actual : "concatenatedBinary(%s) = %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    private static final int MODULO = 1_000_000_007;

    public int concatenatedBinary(int n) {
        StringBuilder sb = new StringBuilder();
        String binaryNumber = "1";
        sb.append(binaryNumber);
        for (int i = 0; i < n - 1; i++) {
            binaryNumber = getNextBinaryNumber(binaryNumber);
            sb.append(binaryNumber);
        }
        long result = 0L;
        for (int i = 0; i < sb.length(); i++) {
            result = ((2 * result) + (sb.charAt(i) - '0')) % MODULO;
        }
        return (int) result;
    }

    private static String getNextBinaryNumber(String binaryNumber) {
        StringBuilder sb = new StringBuilder();
        int carry = 1;
        for (int i = binaryNumber.length() - 1; i >= 0; i--) {
            int num = binaryNumber.charAt(i) - '0' + carry;
            carry = num == 2 ? 1 : 0;
            sb.append(num % 2);
        }
        if (carry == 1) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

}