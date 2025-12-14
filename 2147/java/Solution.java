class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, int expected) {}

        TestCase[] tests = {
                new TestCase("SSPPSPS", 3),
                new TestCase("PPSPSP", 1),
                new TestCase("S", 0)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.numberOfWays(test.in);
            assert test.expected == actual : "numberOfWays(%s) = %s, want %s".formatted(test.in, actual, test.expected);
        }
    }

    private static final int MODULO = 1_000_000_007;

    public int numberOfWays(String corridor) {
        int seatsInGroup = 0;
        int lastSeatIdxPrevGroup = -1;
        long result = 1L;
        for (int i = 0; i < corridor.length(); i++) {
            if (corridor.charAt(i) == 'S') {
                seatsInGroup++;
                if (seatsInGroup == 2) {
                    lastSeatIdxPrevGroup = i;
                    seatsInGroup = 0;
                } else if (seatsInGroup == 1 && lastSeatIdxPrevGroup != -1) {
                    result = result * (i - lastSeatIdxPrevGroup) % MODULO;
                }
            }
        }
        if (seatsInGroup % 2 != 0 || lastSeatIdxPrevGroup == -1) {
            return 0;
        }
        return (int) result;
    }

}