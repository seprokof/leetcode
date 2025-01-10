import java.util.Set;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, String expected) {}

        TestCase[] tests = {
                new TestCase("IceCreAm", "AceCreIm"),
                new TestCase("leetcode", "leotcede")
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.reverseVowels(test.in);
            assert test.expected.equals(actual) : "reverseVowels('%s') == '%s', want '%s'".formatted(test.in, actual,
                    test.expected);
        }
    }

    public String reverseVowels(String s) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        char[] result = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            boolean isLeftVowel = vowels.contains(result[left]);
            if (isLeftVowel && vowels.contains(result[right])) {
                char temp = result[left];
                result[left] = result[right];
                result[right] = temp;
                left++;
                right--;
            } else if (isLeftVowel) {
                right--;
            } else {
                left++;
            }
        }
        return String.valueOf(result);
    }

}