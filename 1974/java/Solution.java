class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, int expected) {}

        TestCase[] tests = {
                new TestCase("abc", 5),
                new TestCase("bza", 7),
                new TestCase("zjpc", 34)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minTimeToType(test.in);
            assert test.expected == actual : "minTimeToType('%s') = %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public int minTimeToType(String word) {
        char currentLetter = 'a';
        int result = 0;
        for (char targetLetter : word.toCharArray()) {
            int leftDistance = Math.abs(targetLetter - currentLetter);
            result += Math.min(leftDistance, 26 - leftDistance) + 1;
            currentLetter = targetLetter;
        }
        return result;
    }

}