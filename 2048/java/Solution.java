class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in, int expected) {}

        TestCase[] tests = {
                new TestCase(1, 22),
                new TestCase(1000, 1333),
                new TestCase(3000, 3133)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.nextBeautifulNumber(test.in);
            assert test.expected == actual : "nextBeautifulNumber(%s) = %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public int nextBeautifulNumber(int n) {
        for (int i = n + 1; i <= 1224444; i++) {
            if (isBalanced(i)) {
                return i;
            }
        }
        return -1;
    }

    private static boolean isBalanced(int num) {
        int[] freq = new int[7];
        while (num > 0) {
            if (num % 10 > 6) {
                return false;
            }
            freq[num % 10]++;
            num /= 10;
        }
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0 && freq[i] != i) {
                return false;
            }
        }
        return true;
    }

}