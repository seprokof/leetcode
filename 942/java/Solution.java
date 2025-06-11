import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, int[] expected) {}
        
        TestCase[] tests = {
                new TestCase("IDID", new int[] { 0, 4, 1, 3, 2 }),
                new TestCase("III", new int[] { 0, 1, 2, 3 }),
                new TestCase("DDI", new int[] { 3, 2, 0, 1 })
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[] actual = s.diStringMatch(test.in);
            assert Arrays.equals(test.expected, actual) : "diStringMatch('%s') == %s, want %s".formatted(test.in,
                    Arrays.toString(actual), Arrays.toString(test.expected));
        }
    }

    public int[] diStringMatch(String s) {
        int[] result = new int[s.length() + 1];
        int i = 0;
        int d = s.length();
        for (int j = 0; j < result.length - 1; j++) {
            result[j] = s.charAt(j) == 'I' ? i++ : d--;
        }
        result[s.length()] = i;
        return result;
    }

}