import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in1, int in2, String expected) {}
        
        TestCase[] tests = {
                new TestCase("dbca", 2, "dbc"),
                new TestCase("gggg", 4, "g")
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.answerString(test.in1, test.in2);
            assert Objects.equals(test.expected, actual) : "answerString('%s', %s) == '%s', want '%s'"
                    .formatted(test.in1, test.in2, actual, test.expected);
        }
    }

    public String answerString(String word, int numFriends) {
        if (numFriends == 1) {
            return word;
        }
        String result = "";
        for (int i = 0; i < word.length(); i++) {
            String substr = word.substring(i, Math.min(i + word.length() - numFriends + 1, word.length()));
            if (substr.compareTo(result) > 0) {
                result = substr;
            }
        }
        return result;
    }

}