class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, int expected) {}

        TestCase[] tests = {
                new TestCase("L_RL__R", 3),
                new TestCase("_R__LL_", 5),
                new TestCase("_______", 7)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.furthestDistanceFromOrigin(test.in);
            assert test.expected == actual : "furthestDistanceFromOrigin('%s') = %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public int furthestDistanceFromOrigin(String moves) {
        int distance = 0;
        int underscores = 0;
        for (char move : moves.toCharArray()) {
            switch (move) {
            case 'L' -> distance--;
            case 'R' -> distance++;
            case '_' -> underscores++;
            }
        }
        return Math.abs(distance) + underscores;
    }

}