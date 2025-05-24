import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String[] in1, char in2, List<Integer> expected) {}
        
        TestCase[] tests = {
                new TestCase(new String[] { "leet", "code" }, 'e', List.of(0, 1)),
                new TestCase(new String[] { "abc", "bcd", "aaaa", "cbc" }, 'a', List.of(0, 2)),
                new TestCase(new String[] { "abc", "bcd", "aaaa", "cbc" }, 'z', List.of())
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            List<Integer> actual = s.findWordsContaining(test.in1, test.in2);
            assert Objects.equals(Set.copyOf(test.expected),
                    Set.copyOf(actual)) : "findWordsContaining(%s, %s) == %s, want %s"
                            .formatted(Arrays.toString(test.in1), test.in2, actual, test.expected);
        }
    }

    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> result = new ArrayList<>(words.length);
        for (int i = 0; i < words.length; i++) {
            if (words[i].indexOf(x) != -1) {
                result.add(i);
            }
        }
        return result;
    }

}