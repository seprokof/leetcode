import java.util.ArrayList;
import java.util.List;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in, List<String> expected) {}

        TestCase[] tests = {
                new TestCase(3, List.of("((()))", "(()())", "(())()", "()(())", "()()()")),
                new TestCase(1, List.of("()"))
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            List<String> actual = s.generateParenthesis(test.in);
            assert areSame(test.expected, actual) : "generateParenthesis(%s) == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    private static boolean areSame(List<String> expected, List<String> actual) {
        return expected.size() == actual.size() && Set.copyOf(expected).equals(Set.copyOf(actual));
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(result, new StringBuilder(), n, n);
        return result;
    }

    private static void generate(List<String> result, StringBuilder sb, int open, int close) {
        if (close == 0) {
            result.add(sb.toString());
            return;
        }
        int size = sb.length();
        if (open > 0) {
            generate(result, sb.append("("), open - 1, close);
            sb.setLength(size);
        }
        if (open < close) {
            generate(result, sb.append(")"), open, close - 1);
            sb.setLength(size);
        }
    }

}