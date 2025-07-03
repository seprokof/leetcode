class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in, char expected) {}

        TestCase[] tests = {
                new TestCase(5, 'b'),
                new TestCase(10, 'c')
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.kthCharacter(test.in);
            assert test.expected == actual : "kthCharacter(%s) == '%s', want '%s'".formatted(test.in, actual,
                    test.expected);
        }
    }

    public char kthCharacter(int k) {
        StringBuilder sb = new StringBuilder().append('a');
        while (sb.length() < k) {
            int len = sb.length();
            for (int i = 0; i < len && sb.length() < k; i++) {
                char ch = sb.charAt(i);
                if (ch == 'z') {
                    sb.append('a');
                } else {
                    sb.append((char) (ch + 1));
                }
            }
        }
        return sb.charAt(k - 1);
    }

}