import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in1, int in2, String expected) {}

        TestCase[] tests = {
                new TestCase("100011001", 3, "11001"),
                new TestCase("1011", 2, "11"),
                new TestCase("000", 1, "")
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.shortestBeautifulSubstring(test.in1, test.in2);
            assert Objects.equals(test.expected, actual) : "shortestBeautifulSubstring('%s', %s) == '%s', want '%s'"
                    .formatted(test.in1, test.in2, actual, test.expected);
        }
    }

    public String shortestBeautifulSubstring(String s, int k) {
        String initial = s + "1";
        String result = initial;
        int start = 0;
        int end = 0;
        int ones = 0;
        while (start <= end && end < s.length()) {
            while (start < s.length() && s.charAt(start) == '0') {
                start++;
            }
            for (; end < s.length() && ones < k; end++) {
                if (s.charAt(end) == '1') {
                    ones++;
                }
            }
            if (ones == k) {
                int len = end - start;
                if (result.length() > len) {
                    result = s.substring(start, end);
                } else if (result.length() == len) {
                    String candidate = s.substring(start, end);
                    if (result.compareTo(candidate) > 0) {
                        result = candidate;
                    }
                }
            }
            ones--;
            start++;
        }
        return result.equals(initial) ? "" : result;
    }

}