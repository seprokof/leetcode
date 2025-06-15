class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in, int expected) {}
        
        TestCase[] tests = {
                new TestCase(555, 888),
                new TestCase(9, 8)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.maxDiff(test.in);
            assert test.expected == actual : "maxDiff(%s) == %s, want %s".formatted(test.in, actual, test.expected);
        }
    }

    public int maxDiff(int num) {
        String numStr = String.valueOf(num);
        int len = numStr.length();
        int i = 0;
        for (; i < len && numStr.charAt(i) == '9'; i++) {
        }
        String maxNum = i == len ? numStr : numStr.replace(numStr.charAt(i), '9');
        char firstChar = numStr.charAt(0);
        String minNum;
        if (firstChar != '1') {
            minNum = numStr.replace(firstChar, '1');
        } else {
            i = 1;
            for (; i < len && (numStr.charAt(i) == '0' || numStr.charAt(i) == firstChar); i++) {
            }
            minNum = i == len ? numStr : numStr.replace(numStr.charAt(i), '0');
        }
        return Integer.parseInt(maxNum) - Integer.parseInt(minNum);
    }

}