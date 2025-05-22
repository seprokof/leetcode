class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in1, String in2, int expected) {}
        
        TestCase[] tests = {
                new TestCase("aA", "aAAbbbb", 3),
                new TestCase("z", "ZZ", 0)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.numJewelsInStones(test.in1, test.in2);
            assert test.expected == actual : "numJewelsInStones(%s, %s) == %s, want %s".formatted(test.in1, test.in2,
                    actual, test.expected);
        }
    }

    public int numJewelsInStones(String jewels, String stones) {
        int[] j = new int[58];
        for (char ch : jewels.toCharArray()) {
            j[ch - 'A'] = 1;
        }
        int result = 0;
        for (char ch : stones.toCharArray()) {
            result += j[ch - 'A'];
        }
        return result;
    }

}