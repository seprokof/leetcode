import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, int expected) {}

        TestCase[] tests = {
                new TestCase("aeiouu", 2),
                new TestCase("unicornarihan", 0),
                new TestCase("cuaieuouac", 7)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.countVowelSubstrings(test.in);
            assert test.expected == actual : "countVowelSubstrings('%s') == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public int countVowelSubstrings(String word) {
        Map<Character, Integer> lastPos = new HashMap<>();
        lastPos.put('a', -1);
        lastPos.put('e', -1);
        lastPos.put('i', -1);
        lastPos.put('o', -1);
        lastPos.put('u', -1);
        int lastConsonant = -1;
        int result = 0;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (lastPos.containsKey(ch)) {
                lastPos.put(ch, i);
                result += Math.max(Collections.min(lastPos.values()) - lastConsonant, 0);
            } else {
                lastConsonant = i;
            }
        }
        return result;
    }

}