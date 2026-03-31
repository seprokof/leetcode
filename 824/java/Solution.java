import java.util.Objects;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, String expected) {}

        TestCase[] tests = {
                new TestCase("I speak Goat Latin", "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"),
                new TestCase("The quick brown fox jumped over the lazy dog", "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa")
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.toGoatLatin(test.in);
            assert Objects.equals(test.expected, actual) : "toGoatLatin('%s') = '%s', want '%s'".formatted(test.in,
                    actual, test.expected);
        }
    }

    private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

    public String toGoatLatin(String sentence) {
        int words = 0;
        Character extra = null;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);
            if (ch == ' ') {
                appendSuffix(sb, extra, ++words);
                extra = null;
                sb.append(ch);
            } else if ((i == 0 || sentence.charAt(i - 1) == ' ') && !VOWELS.contains(ch)) {
                extra = ch;
            } else {
                sb.append(ch);
            }
        }
        appendSuffix(sb, extra, ++words);
        return sb.toString();
    }

    private static void appendSuffix(StringBuilder sb, Character extra, int pos) {
        if (extra != null) {
            sb.append(extra);
        }
        sb.append("ma");
        sb.repeat('a', pos);
    }

}