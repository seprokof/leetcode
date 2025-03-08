class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in1, int in2, int expected) {}

        TestCase[] tests = {
                new TestCase("WBBWWBBWBW", 7, 3),
                new TestCase("WBWBBBW", 2, 0)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minimumRecolors(test.in1, test.in2);
            assert test.expected == actual : "minimumRecolors(%s, %s) == %s, want %s".formatted(test.in1, test.in2,
                    actual, test.expected);
        }
    }

    public int minimumRecolors(String blocks, int k) {
        int countWhite = 0;
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                countWhite++;
            }
        }
        int min = countWhite;
        for (int i = 1; i <= blocks.length() - k; i++) {
            countWhite += blocks.charAt(i + k - 1) == 'W' ? 1 : 0;
            countWhite -= blocks.charAt(i - 1) == 'W' ? 1 : 0;
            min = Math.min(min, countWhite);
        }
        return min;
    }

}