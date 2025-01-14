import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in1, String in2, boolean expected) {}

        TestCase[] tests = {
                new TestCase("abc", "bca", true),
                new TestCase("a", "aa", false),
                new TestCase("cabbba", "abbccc", true)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.closeStrings(test.in1, test.in2);
            assert test.expected == actual : "closeStrings('%s', '%s') == %s, want %s".formatted(test.in1, test.in2,
                    actual, test.expected);
        }
    }

    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        Map<Integer, Integer> word1Map = word1.chars().boxed()
                .collect(Collectors.toMap(Function.identity(), i -> 1, (l, r) -> l + r));
        Map<Integer, Integer> word2Map = word2.chars().boxed()
                .collect(Collectors.toMap(Function.identity(), i -> 1, (l, r) -> l + r));
        if (!word1Map.keySet().equals(word2Map.keySet())) {
            return false;
        }
        List<Integer> word1List = new ArrayList<>(word1Map.values());
        Collections.sort(word1List);
        List<Integer> word2List = new ArrayList<>(word2Map.values());
        Collections.sort(word2List);
        return word1List.equals(word2List);
    }

}