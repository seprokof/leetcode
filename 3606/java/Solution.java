import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Pattern;

class Solution {

    private static final String ELECTRONICS = "electronics";
    private static final String GROCERY = "grocery";
    private static final String PHARMACY = "pharmacy";
    private static final String RESTAURANT = "restaurant";

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String[] in1, String[] in2, boolean[] in3, List<String> expected) {}

        TestCase[] tests = {
                new TestCase(new String[] { "SAVE20", "", "PHARMA5", "SAVE@20" }, new String[] { RESTAURANT, GROCERY, PHARMACY, RESTAURANT }, new boolean[] { true, true, true, true }, List.of("PHARMA5", "SAVE20")),
                new TestCase(new String[] { "GROCERY15", "ELECTRONICS_50", "DISCOUNT10" }, new String[] { GROCERY, ELECTRONICS, "invalid" }, new boolean[] { false, true, true }, List.of("ELECTRONICS_50"))
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            List<String> actual = s.validateCoupons(test.in1, test.in2, test.in3);
            assert Objects.equals(test.expected, actual) : "validateCoupons(%s, %s, %s) = %s, want %s".formatted(
                    Arrays.toString(test.in1), Arrays.toString(test.in2), Arrays.toString(test.in3), actual,
                    test.expected);
        }
    }

    private static final Set<String> VALID_BUSINESS_LINES = Set.of(ELECTRONICS, GROCERY, PHARMACY, RESTAURANT);
    private static final Pattern VALID_CODE_PATTERN = Pattern.compile("\\w+");

    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String[]> valid = new ArrayList<>();
        for (int i = 0; i < code.length; i++) {
            if (!isActive[i] || !VALID_BUSINESS_LINES.contains(businessLine[i])
                    || !VALID_CODE_PATTERN.matcher(code[i]).matches()) {
                continue;
            }
            valid.add(new String[] { code[i], businessLine[i] });
        }
        Collections.sort(valid, (l, r) -> {
            int result = l[1].compareTo(r[1]);
            return result == 0 ? l[0].compareTo(r[0]) : result;
        });
        List<String> result = new ArrayList<>(valid.size());
        for (String[] v : valid) {
            result.add(v[0]);
        }
        return result;
    }

}