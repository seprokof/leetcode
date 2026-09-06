import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, String expected) {}

        TestCase[] tests = {
                new TestCase("Leetcode daily streak achieved", "#leetcodeDailyStreakAchieved"),
                new TestCase("can I Go There", "#canIGoThere"),
                new TestCase("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh", "#hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh")
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.generateTag(test.in);
            assert Objects.equals(test.expected, actual) : "generateTag('%s') == '%s', want '%s'".formatted(test.in,
                    actual, test.expected);
        }
    }

    public String generateTag(String caption) {
        StringBuilder sb = new StringBuilder("#");
        boolean capitalize = false;
        for (int i = 0; i < caption.length() && sb.length() < 100; i++) {
            char ch = caption.charAt(i);
            if (ch == ' ') {
                capitalize = true;
            } else {
                if (capitalize && sb.length() > 1) {
                    sb.append(Character.toUpperCase(ch));
                } else {
                    sb.append(Character.toLowerCase(ch));
                }
                capitalize = false;
            }
        }
        return sb.toString();
    }

}