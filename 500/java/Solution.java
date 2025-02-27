import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String[] in, String[] expected) {}
        
        TestCase[] tests = {
                new TestCase(new String[] { "Hello", "Alaska", "Dad", "Peace" }, new String[] { "Alaska", "Dad" }),
                new TestCase(new String[] { "omk" }, new String[] { }),
                new TestCase(new String[] { "adsdf", "sfd" }, new String[] { "adsdf", "sfd" })
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String[] actual = s.findWords(test.in);
            assert Arrays.equals(test.expected, actual) : "findWords(%s) == %s, want %s"
                    .formatted(Arrays.toString(test.in), Arrays.toString(actual), Arrays.toString(test.expected));
        }
    }

    private static final Map<Character, Integer> KEY_TO_ROW = init();

    private static Map<Character, Integer> init() {
        Map<Character, Integer> keyToRow = new HashMap<>(26);
        put("qwertyuiop", 1, keyToRow);
        put("asdfghjkl", 2, keyToRow);
        put("zxcvbnm", 3, keyToRow);
        return keyToRow;
    }

    private static void put(String letters, Integer rowNum, Map<Character, Integer> destination) {
        for (char ch : letters.toCharArray()) {
            destination.put(ch, rowNum);
        }
    }

    public String[] findWords(String[] words) {
        int len = 0;
        for (int i = 0; i < words.length; i++) {
            boolean remove = false;
            int line = KEY_TO_ROW.get(Character.toLowerCase(words[i].charAt(0)));
            for (int j = 1; j < words[i].length(); j++) {
                if (line != KEY_TO_ROW.get(Character.toLowerCase(words[i].charAt(j)))) {
                    remove = true;
                    break;
                }
            }
            if (!remove) {
                words[len] = words[i];
                len++;
            }
        }
        return Arrays.copyOf(words, len);
    }

}