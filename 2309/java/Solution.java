import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, String expected) {}

        TestCase[] tests = {
                new TestCase("lEeTcOdE", "E"),
                new TestCase("arRAzFif", "R"),
                new TestCase("AbCdEfGhIjK", "")
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.greatestLetter(test.in);
            assert Objects.equals(test.expected, actual) : "greatestLetter('%s') = '%s', want '%s'".formatted(test.in,
                    actual, test.expected);
        }
    }

    public String greatestLetter(String s) {
        for (char letter = 'Z'; letter >= 'A'; letter--) {
            if (s.indexOf(letter) != -1 && s.indexOf(Character.toLowerCase(letter)) != -1) {
                return String.valueOf(letter);
            }
        }
        return "";
    }

}