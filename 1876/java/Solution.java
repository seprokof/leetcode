class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, int expected) {}

        TestCase[] tests = {
                new TestCase("xyzzaz", 1),
                new TestCase("aababcabc", 4)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.countGoodSubstrings(test.in);
            assert test.expected == actual : "countGoodSubstrings('%s') == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public int countGoodSubstrings(String s) {
        char[] arr = s.toCharArray();
        int result = 0;
        for (int i = 2; i < s.length(); i++) {
            if (arr[i] != arr[i - 1] && arr[i - 1] != arr[i - 2] && arr[i] != arr[i - 2]) {
                result++;
            }
        }
        return result;
    }

}