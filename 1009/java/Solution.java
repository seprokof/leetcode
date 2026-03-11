class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in, int expected) {}

        TestCase[] tests = {
                new TestCase(5, 2),
                new TestCase(7, 0),
                new TestCase(10, 5)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.bitwiseComplement(test.in);
            assert test.expected == actual : "bitwiseComplement(%s) = %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public int bitwiseComplement(int n) {
        int complement = 0;
        int i = 0;
        do {
            complement += (1 - n % 2) * 1 << i;
            i++;
            n /= 2;
        } while (n > 0);
        return complement;
    }

}