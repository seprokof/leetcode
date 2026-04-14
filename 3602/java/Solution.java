import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in, String expected) {}

        TestCase[] tests = {
                new TestCase(13, "A91P1"),
                new TestCase(36, "5101000")
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.concatHex36(test.in);
            assert Objects.equals(test.expected, actual) : "concatHex36(%s) = '%s', want '%s'".formatted(test.in,
                    actual, test.expected);
        }
    }

    public String concatHex36(int n) {
        int square = n * n;
        return toBase(square, 16) + toBase(square * n, 36);
    }

    private static String toBase(int num, int base) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            int reminder = num % base;
            if (reminder > 9) {
                sb.append((char) ('A' + reminder - 10));
            } else {
                sb.append(reminder);
            }
            num /= base;
        }
        return sb.reverse().toString();
    }

}