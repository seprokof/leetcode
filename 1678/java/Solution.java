import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, String expected) {}

        TestCase[] tests = {
                new TestCase("G()(al)", "Goal"),
                new TestCase("G()()()()(al)", "Gooooal"),
                new TestCase("(al)G(al)()()G", "alGalooG")
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.interpret(test.in);
            assert Objects.equals(test.expected, actual) : "interpret('%s') = '%s', want '%s'".formatted(test.in,
                    actual, test.expected);
        }
    }

    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < command.length();) {
            if (command.charAt(i) == 'G') {
                sb.append("G");
                i++;
            } else if (command.charAt(i + 1) == ')') {
                sb.append("o");
                i += 2;
            } else {
                sb.append("al");
                i += 4;
            }
        }
        return sb.toString();
    }

}