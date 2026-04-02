import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in1, int in2, String expected) {}

        TestCase[] tests = {
                new TestCase("Hello how are you Contestant", 4, "Hello how are you"),
                new TestCase("What is the solution to this problem", 4, "What is the solution"),
                new TestCase("chopper is not a tanuki", 5, "chopper is not a tanuki")
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.truncateSentence(test.in1, test.in2);
            assert Objects.equals(test.expected, actual) : "truncateSentence('%s', %s) = '%s', want '%s'"
                    .formatted(test.in1, test.in2, actual, test.expected);
        }
    }

    public String truncateSentence(String s, int k) {
        int space = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (++space == k) {
                    return s.substring(0, i);
                }
            }
        }
        return s;
    }

}