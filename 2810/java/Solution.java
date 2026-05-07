import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, String expected) {}

        TestCase[] tests = {
                new TestCase("string", "rtsng"),
                new TestCase("poiinter", "ponter")
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.finalString(test.in);
            assert Objects.equals(test.expected, actual) : "finalString('%s') = '%s', want '%s'".formatted(test.in,
                    actual, test.expected);
        }
    }

    public String finalString(String s) {
        StringBuilder sb = new StringBuilder();
        for (char letter : s.toCharArray()) {
            if (letter == 'i') {
                sb.reverse();
            } else {
                sb.append(letter);
            }
        }
        return sb.toString();
    }

}