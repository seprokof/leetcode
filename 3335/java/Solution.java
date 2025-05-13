class Solution {

    private static final int MODULO = 1_000_000_007;

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in1, int in2, int expected) {}

        TestCase[] tests = {
                new TestCase("abcyy", 2, 7),
                new TestCase("azbk", 1, 5)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.lengthAfterTransformations(test.in1, test.in2);
            assert test.expected == actual : "lengthAfterTransformations(%s, %s) == %s, want %s".formatted(test.in1,
                    test.in2, actual, test.expected);
        }
    }

    public int lengthAfterTransformations(String s, int t) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        int result = s.length();
        for (int i = 0; i < t; i++) {
            int zFreq = freq[25];
            for (int j = 25; j > 0; j--) {
                freq[j] = freq[j - 1];
            }
            freq[0] = zFreq;
            freq[1] = (freq[1] + zFreq) % MODULO;
            result = (result + zFreq) % MODULO;
        }
        return result;
    }

}