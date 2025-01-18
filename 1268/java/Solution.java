import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String[] in1, String in2, List<List<String>> expected) {}

        TestCase[] tests = {
                new TestCase(new String[] { "mobile", "mouse", "moneypot", "monitor", "mousepad" }, "mouse", List.of(List.of("mobile", "moneypot", "monitor"), List.of("mobile", "moneypot", "monitor"), List.of("mouse", "mousepad"), List.of("mouse", "mousepad"), List.of("mouse", "mousepad"))),
                new TestCase(new String[] { "havana" }, "havana", List.of(List.of("havana"), List.of("havana"), List.of("havana"), List.of("havana"), List.of("havana"), List.of("havana")))
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            List<List<String>> actual = s.suggestedProducts(test.in1, test.in2);
            assert Objects.equals(test.expected, actual) : "suggestedProducts(%s, '%s') == %s, want %s"
                    .formatted(Arrays.toString(test.in1), test.in2, actual, test.expected);
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<String> productsList = Arrays.stream(products).filter(p -> p.startsWith(searchWord.substring(0, 1)))
                .sorted().toList();
        List<List<String>> result = new ArrayList<>(searchWord.length());
        for (int i = 0; i < searchWord.length(); i++) {
            List<String> subResult = new ArrayList<>(3);
            String prefix = searchWord.substring(0, i + 1);
            int startIdx = Collections.binarySearch(productsList, prefix);
            if (startIdx < 0) {
                startIdx = Math.abs(startIdx) - 1;
            }
            for (int j = startIdx; j < productsList.size() && subResult.size() != 3; j++) {
                if (!productsList.get(j).startsWith(prefix)) {
                    break;
                }
                subResult.add(productsList.get(j));
            }
            result.add(subResult);
        }
        return result;
    }

}