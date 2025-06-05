import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String[] in, int expected) {}
        
        TestCase[] tests = {
                new TestCase(new String[] { "5", "2", "C", "D", "+" }, 30),
                new TestCase(new String[] { "5", "-2", "4", "C", "D", "9", "+", "+" }, 27),
                new TestCase(new String[] { "1", "C" }, 0)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.calPoints(test.in);
            assert test.expected == actual : "calPoints(%s) == %s, want %s".formatted(Arrays.toString(test.in), actual,
                    test.expected);
        }
    }

    public int calPoints(String[] operations) {
        int[] scores = new int[operations.length];
        int i = 0;
        int result = 0;
        for (String operation : operations) {
            switch (operation) {
                case "+" -> {
                    scores[i] = scores[i - 1] + scores[i - 2];
                    result += scores[i++];
                }
                case "D" -> {
                    scores[i] = scores[i - 1] * 2;
                    result += scores[i++];
                }
                case "C" -> {
                    result -= scores[i - 1];
                    scores[i - 1] = 0;
                    i--;
                }
                default -> {
                    scores[i] = Integer.parseInt(operation);
                    result += scores[i++];
                }
            }
        }
        return result;
    }

}