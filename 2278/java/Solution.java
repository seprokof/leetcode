class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in1, char in2, int expected) {}

        TestCase[] tests = {
                new TestCase("foobar", 'o', 33),
                new TestCase("jjjj", 'k', 0)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.percentageLetter(test.in1, test.in2);
            assert test.expected == actual : "percentageLetter('%s', %s) = %s, want %s".formatted(test.in1, test.in2,
                    actual, test.expected);
        }
    }

    public int percentageLetter(String s, char letter) {
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == letter) {
                count++;
            }
        }
        return count * 100 / s.length();
    }

}