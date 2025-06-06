import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in1, char in2, int[] expected) {}
        
        TestCase[] tests = {
                new TestCase("loveleetcode", 'e', new int[] { 3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0 }),
                new TestCase("aaab", 'b', new int[] { 3, 2, 1, 0 })
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[] actual = s.shortestToChar(test.in1, test.in2);
            assert Arrays.equals(test.expected, actual) : "shortestToChar(%s, %s) == %s, want %s".formatted(test.in1,
                    test.in2, Arrays.toString(actual), Arrays.toString(test.expected));
        }
    }

    public int[] shortestToChar(String s, char c) {
        int[] result = new int[s.length()];
        int idx = Integer.MAX_VALUE;
        int idxNext = s.indexOf(c);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != c) {
                result[i] = Math.min(Math.abs(i - idx), Math.abs(idxNext - i));
            } else {
                idx = idxNext;
                idxNext = s.indexOf(c, idx + 1);
            }
        }
        return result;
    }

}