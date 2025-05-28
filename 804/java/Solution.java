import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {

    private static final String[] MORZE = new String[] { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
            ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
            "-.--", "--.." };

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String[] in, int expected) {}
        
        TestCase[] tests = {
                new TestCase(new String[] { "gin", "zen", "gig", "msg" }, 2),
                new TestCase(new String[] { "a" }, 1)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.uniqueMorseRepresentations(test.in);
            assert test.expected == actual : "uniqueMorseRepresentations(%s) == %s, want %s"
                    .formatted(Arrays.toString(test.in), actual, test.expected);
        }
    }

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> uniqueWords = new HashSet<>(words.length);
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (char ch : word.toCharArray()) {
                sb.append(MORZE[ch - 'a']);
            }
            uniqueWords.add(sb.toString());
        }
        return uniqueWords.size();
    }

}