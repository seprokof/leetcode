import java.util.List;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(List<List<String>> in1, String in2, String in3, int expected) {}

        TestCase[] tests = {
                new TestCase(List.of(List.of("phone", "blue", "pixel"), List.of("computer", "silver", "lenovo"), List.of("phone", "gold", "iphone")), "color", "silver", 1),
                new TestCase(List.of(List.of("phone", "blue", "pixel"), List.of("computer", "silver", "phone"), List.of("phone", "gold", "iphone")), "type", "phone", 2)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.countMatches(test.in1, test.in2, test.in3);
            assert test.expected == actual : "countMatches(%s, %s, %s) == %s, want %s".formatted(test.in1, test.in2,
                    test.in3, actual, test.expected);
        }
    }

    private static final String TYPE = "type";
    private static final String COLOR = "color";
    private static final String NAME = "name";

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int attr = switch (ruleKey) {
            case TYPE -> 0;
            case COLOR -> 1;
            case NAME -> 2;
            default -> -1;
        };
        int result = 0;
        for (List<String> item : items) {
            if (item.get(attr).equals(ruleValue)) {
                result++;
            }
        }
        return result;
    }

}