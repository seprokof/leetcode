class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in1, int in2, int in3, int expected) {}

        TestCase[] tests = {
                new TestCase("cdbcbbaaabab", 4, 5, 19),
                new TestCase("aabbaaxybbaabb", 5, 4, 20)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.maximumGain(test.in1, test.in2, test.in3);
            assert test.expected == actual : "maximumGain(%s, %s, %s) = %s, want %s".formatted(test.in1, test.in2,
                    test.in3, actual, test.expected);
        }
    }

    public int maximumGain(String s, int x, int y) {
        int result = 0;
        StringBuilder sb = new StringBuilder(s);
        if (x > y) {
            result = removeAndCount(sb, "ab") * x;
            result += removeAndCount(sb, "ba") * y;
        } else {
            result = removeAndCount(sb, "ba") * y;
            result += removeAndCount(sb, "ab") * x;
        }
        return result;
    }

    private static int removeAndCount(StringBuilder sb, String str) {
        int removed = 0;
        int j = 0;
        for (int i = 0; i < sb.length(); i++) {
            sb.setCharAt(j, sb.charAt(i));
            if (j > 0 && sb.charAt(j - 1) == str.charAt(0) && sb.charAt(j) == str.charAt(1)) {
                removed++;
                j--;
            } else {
                j++;
            }
        }
        sb.setLength(j);
        return removed;
    }

}