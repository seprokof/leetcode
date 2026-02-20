import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, String expected) {}

        TestCase[] tests = {
                new TestCase("11011000", "11100100"),
                new TestCase("10", "10")
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.makeLargestSpecial(test.in);
            assert Objects.equals(test.expected, actual) : "makeLargestSpecial('%s') = '%s', want '%s'"
                    .formatted(test.in, actual, test.expected);
        }
    }

    public String makeLargestSpecial(String s) {
        int balanced = 0;
        List<String> parts = new ArrayList<>();
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            if (s.charAt(right) == '0') {
                balanced++;
            } else {
                balanced--;
            }
            if (balanced == 0) {
                parts.add("1" + makeLargestSpecial(s.substring(left + 1, right)) + "0");
                left = right + 1;
            }
        }
        Collections.sort(parts, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (String p : parts) {
            sb.append(p);
        }
        return sb.toString();
    }

}