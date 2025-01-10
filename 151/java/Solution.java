import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, String expected) {}

        TestCase[] tests = {
                new TestCase("the sky is blue", "blue is sky the"),
                new TestCase("  hello world  ", "world hello"),
                new TestCase("a good   example", "example good a")
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.reverseWords(test.in);
            assert test.expected.equals(actual) : "reverseWords('%s') == '%s', want '%s'".formatted(test.in, actual,
                    test.expected);
        }
    }

    public String reverseWords(String s) {
        Deque<String> stack = new ArrayDeque<>();
        Arrays.stream(s.split(" ")).filter(Predicate.not(String::isBlank)).forEach(stack::push);
        return stack.stream().collect(Collectors.joining(" "));
    }

}