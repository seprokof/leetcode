class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in, boolean expected) {}

        TestCase[] tests = {
                new TestCase(28, true),
                new TestCase(7, false)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.checkPerfectNumber(test.in);
            assert test.expected == actual : "checkPerfectNumber(%s) == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public boolean checkPerfectNumber(int num) {
        if (num == 1) {
            return false;
        }
        int sum = 1;
        for (int i = 2; i < Math.ceil(Math.sqrt(num)); i++) {
            if (num % i == 0) {
                sum += i;
                sum += num / i;
            }
        }
        return num == sum;
    }

}