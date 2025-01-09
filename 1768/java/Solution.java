class Solution {

    public static void main(String[] args) {
        record TestCase(String in1, String in2, String expected) {}

        TestCase[] tests = {
                new TestCase("abc", "pqr", "apbqcr"),
                new TestCase("ab", "pqrs", "apbqrs"),
                new TestCase("abcd", "pq", "apbqcd")
                };

        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.mergeAlternately(test.in1, test.in2);
            assert test.expected.equals(actual) : "mergeAlternately('%s', '%s') == '%s', want '%s'".formatted(test.in1,
                    test.in2, actual, test.expected);
        }
    }

    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder(word1.length() + word2.length());
        for (int i = 0; i < Math.min(word1.length(), word2.length()); i++) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }
        if (word2.length() > word1.length()) {
            sb.append(word2.substring(word1.length()));
        } else if (word1.length() > word2.length()) {
            sb.append(word1.substring(word2.length()));
        }
        return sb.toString();
    }

}