import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, String expected) {}

        TestCase[] tests = {
                new TestCase("1.1.1.1", "1[.]1[.]1[.]1"),
                new TestCase("255.100.50.0", "255[.]100[.]50[.]0")
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.defangIPaddr(test.in);
            assert Objects.equals(test.expected, actual) : "defangIPaddr('%s') = '%s', want '%s'".formatted(test.in,
                    actual, test.expected);
        }
    }

    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }

}