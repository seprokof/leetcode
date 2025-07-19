import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String[] in, List<String> expected) {}

        TestCase[] tests = {
                new TestCase(new String[] { "/a", "/a/b", "/c/d", "/c/d/e", "/c/f" }, List.of("/a", "/c/d", "/c/f")),
                new TestCase(new String[] { "/a", "/a/b/c", "/a/b/d" }, List.of("/a")),
                new TestCase(new String[] { "/a/b/c", "/a/b/ca", "/a/b/d" }, List.of("/a/b/c", "/a/b/ca", "/a/b/d"))
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            List<String> actual = s.removeSubfolders(Arrays.copyOf(test.in, test.in.length));
            assert Objects.equals(test.expected, actual) : "removeSubfolders(%s) == %s, want %s"
                    .formatted(Arrays.toString(test.in), actual, test.expected);
        }
    }

    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> result = new ArrayList<>();
        result.add(folder[0]);
        for (int i = 1; i < folder.length; i++) {
            String last = result.getLast();
            if (!folder[i].startsWith(last + "/")) {
                result.add(folder[i]);
            }
        }
        return result;
    }

}