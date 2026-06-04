class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in1, int in2, int expected) {}

        TestCase[] tests = {
                new TestCase(120, 130, 3),
                new TestCase(198, 202, 3),
                new TestCase(4848, 4848, 2)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.totalWaviness(test.in1, test.in2);
            assert test.expected == actual : "totalWaviness(%s, %s) == %s, want %s".formatted(test.in1, test.in2,
                    actual, test.expected);
        }
    }

    public int totalWaviness(int num1, int num2) {
        int result = 0;
        for (int n = num1; n <= num2; n++) {
            result += getWaviness(n);
        }
        return result;
    }

    private static int getWaviness(int num) {
        if (num < 101) {
            return 0;
        }
        int previous = num % 10;
        num /= 10;
        int current = num % 10;
        num /= 10;
        int result = 0;
        while (num != 0) {
            int next = num % 10;
            num /= 10;
            if ((current > previous && current > next) || (current < previous && current < next)) {
                result++;
            }
            previous = current;
            current = next;
        }
        return result;
    }

}