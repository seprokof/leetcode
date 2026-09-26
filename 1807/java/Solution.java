import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in1, List<List<String>> in2, String expected) {}

        TestCase[] tests = {
                new TestCase("(name)is(age)yearsold", List.of(List.of("name", "bob"), List.of("age", "two")), "bobistwoyearsold"),
                new TestCase("hi(name)", List.of(List.of("a", "b")), "hi?"),
                new TestCase("(a)(a)(a)aaa", List.of(List.of("a", "yes")), "yesyesyesaaa")
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.evaluate(test.in1, test.in2);
            assert Objects.equals(test.expected, actual) : "evaluate('%s', %s) = '%s', want '%s'".formatted(test.in1,
                    test.in2, actual, test.expected);
        }
    }

    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>(knowledge.size());
        for (List<String> k : knowledge) {
            map.put(k.getFirst(), k.getLast());
        }
        boolean isKey = false;
        StringBuilder result = new StringBuilder();
        StringBuilder key = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                isKey = true;
            } else if (ch == ')') {
                isKey = false;
                result.append(map.getOrDefault(key.toString(), "?"));
                key.setLength(0);
            } else if (isKey) {
                key.append(ch);
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

}