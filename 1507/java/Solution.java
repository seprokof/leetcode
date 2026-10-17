import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, String expected) {}

        TestCase[] tests = {
                new TestCase("20th Oct 2052", "2052-10-20"),
                new TestCase("6th Jun 1933", "1933-06-06"),
                new TestCase("26th May 1960", "1960-05-26")
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.reformatDate(test.in);
            assert Objects.equals(test.expected, actual) : "reformatDate('%s') == '%s', want '%s'".formatted(test.in,
                    actual, test.expected);
        }
    }

    private static final Map<String, String> MONTHS;

    static {
        Map<String, String> months = new HashMap<>();
        months.put("Jan", "01");
        months.put("Feb", "02");
        months.put("Mar", "03");
        months.put("Apr", "04");
        months.put("May", "05");
        months.put("Jun", "06");
        months.put("Jul", "07");
        months.put("Aug", "08");
        months.put("Sep", "09");
        months.put("Oct", "10");
        months.put("Nov", "11");
        months.put("Dec", "12");
        MONTHS = Map.copyOf(months);
    }

    public String reformatDate(String date) {
        StringBuilder result = new StringBuilder();
        if (date.length() == 13) {
            result.append(date.substring(9))
                .append("-")
                .append(MONTHS.get(date.subSequence(5, 8)))
                .append("-")
                .append(date.substring(0, 2));
        } else {
            result.append(date.substring(8))
                .append("-")
                .append(MONTHS.get(date.subSequence(4, 7)))
                .append("-")
                .append("0").append(date.substring(0, 1));
        }
        return result.toString();
    }

}