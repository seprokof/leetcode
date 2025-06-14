class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in, int expected) {}
        
        TestCase[] tests = {
                new TestCase(11891, 99009),
                new TestCase(90, 99)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minMaxDifference(test.in);
            assert test.expected == actual : "minMaxDifference(%s) == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public int minMaxDifference(int num) {
        String numStr = String.valueOf(num);
        int i = 0;
        for (; i < numStr.length() && numStr.charAt(i) == '9'; i++) {
        }
        String minStr = numStr.replace(numStr.charAt(0), '0');
        String maxStr = i == numStr.length() ? numStr : numStr.replace(numStr.charAt(i), '9');
        return Integer.parseInt(maxStr) - Integer.parseInt(minStr);
    }

}