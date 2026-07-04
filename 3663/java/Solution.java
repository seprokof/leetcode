class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in, int expected) {}

        TestCase[] tests = {
                new TestCase(1553322, 1),
                new TestCase(723344511, 2)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.getLeastFrequentDigit(test.in);
            assert test.expected == actual : "getLeastFrequentDigit(%s) == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public int getLeastFrequentDigit(int n) {
        int[] frequency = new int[10];
        while (n > 0) {
            int digit = n % 10;
            frequency[digit]++;
            n /= 10;
        }
        int minFrequency = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0 && frequency[i] < minFrequency) {
                minFrequency = frequency[i];
                result = i;
            }
        }
        return result;
    }

}