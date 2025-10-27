import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new String[] { "011001", "000000", "010100", "001000" }, 8),
                new TestCase(new String[] { "000", "111", "000" }, 0)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.numberOfBeams(test.in);
            assert test.expected == actual : "numberOfBeams(%s) = %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public int numberOfBeams(String[] bank) {
        int result = 0;
        int prev = 0;
        for (String row : bank) {
            int current = 0;
            for (char ch : row.toCharArray()) {
                if (ch == '1') {
                    current++;
                }
            }
            if (current != 0) {
                result += prev * current;
                prev = current;
            }
        }
        return result;
    }

}