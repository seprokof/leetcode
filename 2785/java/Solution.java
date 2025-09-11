import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;

class Solution {

    private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, String expected) {}

        TestCase[] tests = {
                new TestCase("lEetcOde", "lEOtcede"),
                new TestCase("lYmpH", "lYmpH")
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.sortVowels(test.in);
            assert Objects.equals(test.expected, actual) : "sortVowels('%s') = '%s', want '%s'".formatted(test.in,
                    actual, test.expected);
        }
    }

    public String sortVowels(String s) {
        List<Character> foundVowels = new ArrayList<>();
        char[] result = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (VOWELS.contains(letter)) {
                foundVowels.add(letter);
            } else {
                result[i] = letter;
            }
        }
        Collections.sort(foundVowels);
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (result[i] == Character.MIN_VALUE) {
                result[i] = foundVowels.get(j++);
            }
        }
        return new String(result);
    }

}