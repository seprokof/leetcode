class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in1, int in2, int expected) {}

        TestCase[] tests = {
                new TestCase("baeyh", 2, 2),
                new TestCase("abba", 1, 3),
                new TestCase("bcdf", 1, 0)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.beautifulSubstrings(test.in1, test.in2);
            assert test.expected == actual : "beautifulSubstrings('%s', %s) == %s, want %s".formatted(test.in1,
                    test.in2, actual, test.expected);
        }
    }

    public int beautifulSubstrings(String s, int k) {
        int[] vPrefSum = new int[s.length() + 1];
        vPrefSum[0] = 0;
        int[] cPrefSum = new int[s.length() + 1];
        cPrefSum[0] = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vPrefSum[i + 1] = vPrefSum[i] + 1;
                cPrefSum[i + 1] = cPrefSum[i];
            } else {
                vPrefSum[i + 1] = vPrefSum[i];
                cPrefSum[i + 1] = cPrefSum[i] + 1;
            }
        }
        int result = 0;
        for (int i = 1; i < s.length(); i++) {
            for (int j = i; j <= s.length(); j++) {
                int vowels = vPrefSum[j] - vPrefSum[i - 1];
                int consonants = cPrefSum[j] - cPrefSum[i - 1];
                if (vowels == consonants && (vowels * consonants) % k == 0) {
                    result++;
                }
            }
        }
        return result;
    }

}