import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in1, int in2, String expected) {}

        TestCase[] tests = {
                new TestCase(1, 2, "0.5"),
                new TestCase(2, 1, "2"),
                new TestCase(4, 333, "0.(012)")
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.fractionToDecimal(test.in1, test.in2);
            assert Objects.equals(test.expected, actual) : "fractionToDecimal(%s, %s) = '%s', want '%s'"
                    .formatted(test.in1, test.in2, actual, test.expected);
        }
    }

    public String fractionToDecimal(int numerator, int denominator) {
        long lnumerator = (long) numerator;
        long ldenominator = (long) denominator;
        StringBuilder sb = new StringBuilder();
        if (lnumerator * denominator < 0) {
            sb.append('-');
        }
        lnumerator = Math.abs(lnumerator);
        ldenominator = Math.abs(ldenominator);
        boolean isDotUsed = false;
        Map<Long, Integer> reminderToPosition = new HashMap<>();
        while (true) {
            sb.append(lnumerator / ldenominator);
            long reminder = lnumerator % ldenominator;
            if (reminder == 0) {
                return sb.toString();
            }
            if (!isDotUsed) {
                isDotUsed = true;
                sb.append('.');
            }
            if (reminderToPosition.containsKey(reminder)) {
                sb.insert((int) reminderToPosition.get(reminder), '(');
                sb.append(')');
                return sb.toString();
            }
            reminderToPosition.put(reminder, sb.length());
            reminder *= 10;
            while (reminder < ldenominator) {
                reminder *= 10;
                sb.append('0');
            }
            lnumerator = reminder;
        }
    }

}