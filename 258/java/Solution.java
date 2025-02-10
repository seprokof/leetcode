class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in, int expected) {}

        TestCase[] tests = {
                new TestCase(38, 2),
                new TestCase(0, 0)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.addDigits(test.in);
            assert test.expected == actual : "addDigits(%s) == %s, want %s".formatted(test.in, actual, test.expected);
        }
    }

    public int addDigits(int num) {
        // return num < 10 ? num : addDigits(num % 10 + addDigits(num / 10));
        //
        // digital root https://en.wikipedia.org/wiki/Digital_root
        return (num % 9 == 0 && num != 0) ? 9 : num % 9;
    }

}