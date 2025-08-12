import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String[] in, List<String> expected) {}

        TestCase[] tests = {
                new TestCase(new String[] { "mass", "as", "hero", "superhero" }, List.of("as", "hero")),
                new TestCase(new String[] { "leetcode", "et", "code" }, List.of("et", "code")),
                new TestCase(new String[] { "blue", "green", "bu" }, List.of())
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            List<String> actual = s.stringMatching(Arrays.copyOf(test.in, test.in.length));
            assert containsSameElements(test.expected, actual) : "stringMatching(%s) = %s, want %s"
                    .formatted(Arrays.toString(test.in), actual, test.expected);
        }
    }

    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();
        Arrays.sort(words, (left, right) -> left.length() - right.length());
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[j].contains(words[i])) {
                    result.add(words[i]);
                    break;
                }
            }
        }
        return result;
    }

    private static <T> boolean containsSameElements(List<T> list1, List<T> list2) {
        if (list1 == null) {
            return list2 == null;
        }
        if (list2 == null) {
            return list1 == null;
        }
        if (list1.size() != list2.size()) {
            return false;
        }
        Set<T> set1 = new HashSet<>(list1);
        Set<T> set2 = new HashSet<>(list2);
        return set1.equals(set2);
    }

}