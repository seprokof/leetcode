class Solution extends GuessGame {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in1, int in2, int expected) {}

        TestCase[] tests = {
                new TestCase(10, 6, 6),
                new TestCase(1, 1, 1),
                new TestCase(2, 1, 1)
                };
        // @formatter:on

        for (TestCase test : tests) {
            Solution s = new Solution(test.in2);
            int actual = s.guessNumber(test.in1);
            assert test.expected == actual : "(picked %s) guessNumber(%s) == %s, want %s".formatted(test.in2,
                    test.in1, actual, test.expected);
        }
    }

    public Solution(Integer picked) {
        super(picked);
    }

    public int guessNumber(int n) {
        return guessNumber(1, n);
    }

    private int guessNumber(int left, int right) {
        int mid = (right - left) / 2 + left;
        int result = guess(mid);
        if (result == 0) {
            return mid;
        } else if (result < 0) {
            return guessNumber(left, mid - 1);
        } else {
            return guessNumber(mid + 1, right);
        }
    }

}