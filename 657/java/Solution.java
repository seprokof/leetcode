class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, boolean expected) {}

        TestCase[] tests = {
                new TestCase("UD", true),
                new TestCase("LL", false)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.judgeCircle(test.in);
            assert test.expected == actual : "judgeCircle(%s) == %s, want %s".formatted(test.in, actual, test.expected);
        }
    }

    public boolean judgeCircle(String moves) {
        int[] countMoves = new int[4];
        for (char ch : moves.toCharArray()) {
            switch (ch) {
            case 'R' -> countMoves[0]++;
            case 'U' -> countMoves[1]++;
            case 'L' -> countMoves[2]++;
            case 'D' -> countMoves[3]++;
            }
        }
        return (countMoves[0] == countMoves[2]) && (countMoves[1] == countMoves[3]);
    }

}