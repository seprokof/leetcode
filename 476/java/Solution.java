class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in, int expected) {}
        
        TestCase[] tests = {
                new TestCase(5, 2),
                new TestCase(1, 0)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.findComplement(test.in);
            assert test.expected == actual : "findComplement(%s) == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public int findComplement(int num) {
        int complement = 0;
        for (int i = 0; num > 0; i++) {
            if ((num & 1) == 0) {
                complement += Math.pow(2, i);
            }
            num = num >> 1;
        }
        return complement;
    }

}