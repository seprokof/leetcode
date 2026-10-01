class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, int expected) {}

        TestCase[] tests = {
                new TestCase("EEEEEEE", 7),
                new TestCase("ELELEEL", 2),
                new TestCase("ELEELEELLL", 3)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minimumChairs(test.in);
            assert test.expected == actual : "minimumChairs('%s') = %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public int minimumChairs(String s) {
        int current = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'E') {
                max = Math.max(max, ++current);
            } else {
                current--;
            }
        }
        return max;
    }

}