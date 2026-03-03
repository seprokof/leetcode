class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in1, int in2, char expected) {}

        TestCase[] tests = {
                new TestCase(3, 1, '0'),
                new TestCase(4, 11, '1')
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            char actual = s.findKthBit(test.in1, test.in2);
            assert test.expected == actual : "findKthBit(%s, %s) = '%s', want '%s'".formatted(test.in1, test.in2,
                    actual, test.expected);
        }
    }

    public char findKthBit(int n, int k) {
        StringBuilder sb = new StringBuilder("0");
        for (int i = 1; i < n && k > sb.length(); i++) {
            sb.append('1');
            for (int j = sb.length() - 2; j >= 0; j--) {
                sb.append(sb.charAt(j) == '0' ? '1' : '0');
            }
        }
        return sb.charAt(k - 1);
    }

}