import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, Set<String> expected) {}

        TestCase[] tests = {
                new TestCase("23", Set.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf")),
                new TestCase("", Set.of()),
                new TestCase("2", Set.of("a", "b", "c"))
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            Set<String> actual = new HashSet<>(s.letterCombinations(test.in));
            assert test.expected.equals(new HashSet<>(actual)) : "letterCombinations('%s') == %s, want %s"
                    .formatted(test.in, actual, test.expected);
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return List.of();
        }
        Map<Character, Set<Character>> mappings = new HashMap<>(8);
        mappings.put('2', Set.of('a', 'b', 'c'));
        mappings.put('3', Set.of('d', 'e', 'f'));
        mappings.put('4', Set.of('g', 'h', 'i'));
        mappings.put('5', Set.of('j', 'k', 'l'));
        mappings.put('6', Set.of('m', 'n', 'o'));
        mappings.put('7', Set.of('p', 'q', 'r', 's'));
        mappings.put('8', Set.of('t', 'u', 'v'));
        mappings.put('9', Set.of('w', 'x', 'y', 'z'));

        LinkedList<String> result = new LinkedList<>();
        for (char digit : digits.toCharArray()) {
            int size = result.size();
            Set<Character> letters = mappings.get(Character.valueOf(digit));
            if (size == 0) {
                letters.stream().map(String::valueOf).forEach(result::offer);
            } else {
                for (int i = 0; i < size; i++) {
                    String current = result.poll();
                    for (Character ch : letters) {
                        result.offer(current + ch);
                    }
                }
            }
        }
        return result;
    }

}