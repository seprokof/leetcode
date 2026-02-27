import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in1, String in2, String[] expected) {}

        TestCase[] tests = {
                new TestCase("this apple is sweet", "this apple is sour", new String[] { "sweet", "sour" }),
                new TestCase("apple apple", "banana", new String[] { "banana" })
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String[] actual = s.uncommonFromSentences(test.in1, test.in2);
            assert haveSameElements(test.expected, actual) : "uncommonFromSentences('%s', '%s') = %s, want %s"
                    .formatted(test.in1, test.in2, Arrays.toString(actual), Arrays.toString(test.expected));
        }
    }

    private static boolean haveSameElements(String[] expected, String[] actual) {
        if (expected.length != actual.length) {
            return false;
        }
        return Set.of(expected).equals(Set.of(actual));
    }

    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> frequency = new HashMap<>();
        for (String word : s1.split(" ")) {
            frequency.merge(word, 1, Integer::sum);
        }
        for (String word : s2.split(" ")) {
            frequency.merge(word, 1, Integer::sum);
        }
        List<String> uncommon = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : frequency.entrySet()) {
            if (entry.getValue() == 1) {
                uncommon.add(entry.getKey());
            }
        }
        return uncommon.toArray(new String[0]);
    }

}