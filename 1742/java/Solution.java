class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in1, int in2, int expected) {}

        TestCase[] tests = {
                new TestCase(1, 10, 2),
                new TestCase(5, 15, 2),
                new TestCase(19, 28, 2)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.countBalls(test.in1, test.in2);
            assert test.expected == actual : "countBalls(%s, %s) = %s, want %s".formatted(test.in1, test.in2, actual,
                    test.expected);
        }
    }

    public int countBalls(int lowLimit, int highLimit) {
        int[] boxToCount = new int[46];
        int max = 0;
        for (int i = lowLimit; i <= highLimit; i++) {
            int num = i;
            int sum = 0;
            while (num != 0) {
                sum += num % 10;
                num /= 10;
            }
            max = Math.max(max, ++boxToCount[sum]);
        }
        return max;
    }

}