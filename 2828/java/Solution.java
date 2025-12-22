import java.util.List;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(List<String> in1, String in2, boolean expected) {}

        TestCase[] tests = {
                new TestCase(List.of("alice", "bob", "charlie"), "abc", true),
                new TestCase(List.of("an", "apple"), "a", false),
                new TestCase(List.of("never", "gonna", "give", "up", "on", "you"), "ngguoy", true)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.isAcronym(test.in1, test.in2);
            assert test.expected == actual : "isAcronym(%s, '%s') = %s, want %s".formatted(test.in1, test.in2, actual,
                    test.expected);
        }
    }

    public boolean isAcronym(List<String> words, String s) {
        if (words.size() != s.length()) {
            return false;
        }
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).charAt(0) != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }

}