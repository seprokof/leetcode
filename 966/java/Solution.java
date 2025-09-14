import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String[] in1, String[] in2, String[] expected) {}

        TestCase[] tests = {
                new TestCase(new String[] { "KiTe", "kite", "hare", "Hare" }, new String[] { "kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto" }, new String[] { "kite", "KiTe", "KiTe", "Hare", "hare", "", "", "KiTe", "", "KiTe" }),
                new TestCase(new String[] { "yellow" }, new String[] { "YellOw" }, new String[] { "yellow" })
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String[] actual = s.spellchecker(test.in1, test.in2);
            assert Arrays.equals(test.expected, actual) : "spellchecker(%s, %s) = %s, want %s".formatted(
                    Arrays.toString(test.in1), Arrays.toString(test.in2), Arrays.toString(actual),
                    Arrays.toString(test.expected));
        }
    }

    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exact = new HashSet<>(wordlist.length);
        Map<String, String> capitalization = new HashMap<>(wordlist.length);
        Map<String, String> vowelError = new HashMap<>(wordlist.length);
        for (String word : wordlist) {
            exact.add(word);
            String wordLc = word.toLowerCase();
            capitalization.putIfAbsent(wordLc, word);
            vowelError.putIfAbsent(maskVowels(wordLc), word);
        }
        String[] answer = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            if (exact.contains(query)) {
                answer[i] = query;
                continue;
            }
            String queryLc = query.toLowerCase();
            String fixed = capitalization.get(queryLc);
            if (fixed == null) {
                fixed = vowelError.get(maskVowels(queryLc));
                if (fixed == null) {
                    fixed = "";
                }
            }
            answer[i] = fixed;
        }
        return answer;
    }

    private static String maskVowels(String word) {
        StringBuilder sb = new StringBuilder(word.length());
        for (char letter : word.toCharArray()) {
            switch (letter) {
            case 'a', 'e', 'i', 'o', 'u' -> sb.append('*');
            default -> sb.append(letter);
            }
        }
        return sb.toString();
    }

}