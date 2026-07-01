import java.util.Arrays;
import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in1, String[] in2, String expected) {}

        TestCase[] tests = {
                new TestCase("1s3 PSt", new String[] { "step", "steps", "stripe", "stepple" }, "steps"),
                new TestCase("1s3 456", new String[] { "looks", "pest", "stew", "show"}, "pest")
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.shortestCompletingWord(test.in1, test.in2);
            assert Objects.equals(test.expected, actual) : "shortestCompletingWord('%s', %s) == '%s', want '%s'"
                    .formatted(test.in1, Arrays.toString(test.in2), actual, test.expected);
        }
    }

    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] lpFreq = new int[26];
        for (int i = 0; i < licensePlate.length(); i++) {
            char ch = licensePlate.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                lpFreq[ch - 'A']++;
            } else if (ch >= 'a' && ch <= 'z') {
                lpFreq[ch - 'a']++;
            }
        }
        String result = null;
        for (String word : words) {
            int[] freq = new int[26];
            for (int i = 0; i < word.length(); i++) {
                freq[word.charAt(i) - 'a']++;
            }
            boolean isCompleting = true;
            for (int i = 0; i < 26; i++) {
                if (lpFreq[i] > freq[i]) {
                    isCompleting = false;
                    break;
                }
            }
            if (isCompleting && (result == null || result.length() > word.length())) {
                result = word;
            }
        }
        return result;
    }

}