class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, int expected) {}
        
        TestCase[] tests = {
                new TestCase("Hello, my name is John", 5),
                new TestCase("Hello", 1)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.countSegments(test.in);
            assert test.expected == actual : "countSegments('%s') == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public int countSegments(String s) {
        int count = 0;
        int startIdx = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (startIdx > -1) {
                    count++;
                    startIdx = -1;
                }
            } else if (startIdx == -1) {
                startIdx = i;
            }
        }
        return count + (startIdx > -1 ? 1 : 0);
    }
}