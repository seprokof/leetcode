import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String[] in1, String[] in2, boolean expected) {}

        TestCase[] tests = {
                new TestCase(new String[] { "01:15", "02:00" }, new String[] { "02:00", "03:00" }, true),
                new TestCase(new String[] { "01:00", "02:00" }, new String[] { "01:20", "03:00" }, true),
                new TestCase(new String[] { "10:00", "11:00" }, new String[] { "14:00", "15:00" }, false)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.haveConflict(test.in1, test.in2);
            assert test.expected == actual : "haveConflict(%s, %s) = %s, want %s".formatted(Arrays.toString(test.in1),
                    Arrays.toString(test.in2), actual, test.expected);
        }
    }

    public boolean haveConflict(String[] event1, String[] event2) {
        return event1[0].compareTo(event2[1]) <= 0 && event2[0].compareTo(event1[1]) <= 0;
    }

}