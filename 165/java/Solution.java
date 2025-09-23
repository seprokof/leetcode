class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in1, String in2, int expected) {}

        TestCase[] tests = {
                new TestCase("1.2", "1.10", -1),
                new TestCase("1.01", "1.001", 0),
                new TestCase("1.0", "1.0.0.0", 0)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.compareVersion(test.in1, test.in2);
            assert test.expected == actual : "compareVersion('%s', '%s') = %s, want %s".formatted(test.in1, test.in2,
                    actual, test.expected);
        }
    }

    public int compareVersion(String version1, String version2) {
        for (int end1 = 0, end2 = 0; end1 < version1.length() || end2 < version2.length();) {
            int v1 = 0;
            while (end1 < version1.length()) {
                char ch = version1.charAt(end1);
                end1++;
                if (ch == '.') {
                    break;
                }
                v1 = v1 * 10 + (ch - '0');
            }
            int v2 = 0;
            while (end2 < version2.length()) {
                char ch = version2.charAt(end2);
                end2++;
                if (ch == '.') {
                    break;
                }
                v2 = v2 * 10 + (ch - '0');
            }
            int result = Integer.compare(v1, v2);
            if (result != 0) {
                return result;
            }
        }
        return 0;
    }

}