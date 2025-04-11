class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in1, int in2, int expected) {}

        TestCase[] tests = {
                new TestCase(1, 100, 9),
                new TestCase(1200, 1230, 4)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.countSymmetricIntegers(test.in1, test.in2);
            assert test.expected == actual : "countSymmetricIntegers(%s, %s) == %s, want %s".formatted(test.in1,
                    test.in2, actual, test.expected);
        }
    }

    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        int num = low;
        while (num <= high) {
            String str = String.valueOf(num);
            if (str.length() % 2 != 0) {
                num = (int) Math.pow(10, str.length()) + 1;
                continue;
            }
            int sum = 0;
            for (int i = 0; i < str.length() / 2; i++) {
                sum = sum + (str.charAt(i) - '0') - (str.charAt(str.length() - 1 - i) - '0');
            }
            if (sum == 0) {
                count++;
            }
            num++;
        }
        return count;
    }

}