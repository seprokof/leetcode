class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, int expected) {}
        
        TestCase[] tests = {
                new TestCase("leetcode", 0),
                new TestCase("loveleetcode", 2),
                new TestCase("aabb", -1)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.firstUniqChar(test.in);
            assert test.expected == actual : "firstUniqChar('%s') == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public int firstUniqChar(String s) {
        int[] letterCount = new int[26];
        char[] str = s.toCharArray();
        for (char ch : str) {
            letterCount[ch - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (letterCount[str[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

}