import java.util.ArrayList;
import java.util.List;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in, Set<String> expected) {}

        TestCase[] tests = {
                new TestCase(1, Set.of("0:01", "0:02", "0:04", "0:08", "0:16", "0:32", "1:00", "2:00", "4:00", "8:00")),
                new TestCase(9, Set.of())
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            List<String> actual = s.readBinaryWatch(test.in);
            assert (test.expected.size() == actual.size()
                    && test.expected.containsAll(actual)) : "readBinaryWatch(%s) = %s, want %s".formatted(test.in,
                            actual, test.expected);
        }
    }

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();
        for (int hour = 0; hour < 12; hour++) {
            int hourBitCount = Integer.bitCount(hour);
            for (int minute = 0; minute < 60; minute++) {
                if (hourBitCount + Integer.bitCount(minute) == turnedOn) {
                    result.add(hour + ":" + (minute > 9 ? minute : "0" + minute));
                }
            }
        }
        return result;
    }

}