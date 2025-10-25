class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in, int expected) {}

        TestCase[] tests = {
                new TestCase(4, 10),
                new TestCase(10, 37),
                new TestCase(20, 96)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.totalMoney(test.in);
            assert test.expected == actual : "totalMoney(%s) = %s, want %s".formatted(test.in, actual, test.expected);
        }
    }

    public int totalMoney(int n) {
        int fullWeeks = n / 7;
        int result = 0;
        for (int i = 0; i < fullWeeks; i++) {
            result += 28 + i * 7;
        }
        for (int i = 0, dayIncome = ++fullWeeks; i < n % 7; i++, dayIncome++) {
            result += dayIncome;
        }
        return result;
    }

}