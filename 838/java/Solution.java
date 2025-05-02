import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, String expected) {}

        TestCase[] tests = {
                new TestCase("RR.L", "RR.L"),
                new TestCase(".L.R...LR..L..", "LL.RR.LLRRLL..")
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.pushDominoes(test.in);
            assert Objects.equals(test.expected, actual) : "pushDominoes(%s) == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        int[] force = new int[n];
        int f = 0;
        for (int i = 0; i < n; i++) {
            char ch = dominoes.charAt(i);
            if (ch == 'R') {
                f = n;
            } else if (ch == '.') {
                f = Math.max(0, f - 1);
            } else {
                f = 0;
            }
            force[i] = f;
        }
        f = 0;
        char[] result = new char[n];
        for (int i = n - 1; i >= 0; i--) {
            char ch = dominoes.charAt(i);
            if (ch == 'L') {
                f = n;
            } else if (ch == '.') {
                f = Math.max(0, f - 1);
            } else {
                f = 0;
            }
            force[i] -= f;
            if (force[i] == 0) {
                result[i] = '.';
            } else if (force[i] > 0) {
                result[i] = 'R';
            } else {
                result[i] = 'L';
            }
        }
        return String.valueOf(result);
    }

}