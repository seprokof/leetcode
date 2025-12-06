class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in1, int in2, int in3, int expected) {}

        TestCase[] tests = {
                new TestCase(1, 10, 1000, 0),
                new TestCase(987, 879, 798, 777),
                new TestCase(1, 2, 3, 1)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.generateKey(test.in1, test.in2, test.in3);
            assert test.expected == actual : "generateKey(%s, %s, %s) = %s, want %s".formatted(test.in1, test.in2,
                    test.in3, actual, test.expected);
        }
    }

    public int generateKey(int num1, int num2, int num3) {
        int result = 0;
        for (int i = 1; i < 10000; i *= 10) {
            int min = num1 % 10;
            num1 /= 10;
            min = Math.min(min, num2 % 10);
            num2 /= 10;
            min = Math.min(min, num3 % 10);
            num3 /= 10;
            result += min * i;
        }
        return result;
    }

}