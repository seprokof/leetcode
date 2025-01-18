import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        
        // @formatter:off
        record TestCase(String[] in1, String[] in2, Boolean[] expected) {}

        TestCase[] tests = {
                new TestCase(new String[] { "insert", "search", "search", "startsWith", "insert", "search" }, new String[] { "apple", "apple", "app", "app", "app", "app" }, new Boolean[] { null, true, false, true, null, true })
                };
         // @formatter:on

        for (TestCase test : tests) {
            Trie trie = new Trie();
            for (int i = 0; i < test.in1.length; i++) {
                if ("insert".equals(test.in1[i])) {
                    trie.insert(test.in2[i]);
                } else if ("search".equals(test.in1[i])) {
                    Boolean actual = trie.search(test.in2[i]);
                    assert Objects.equals(test.expected[i], actual) : "search('%s') == %s, want %s"
                            .formatted(test.in2[i], actual, test.expected);
                } else if ("startsWith".equals(test.in1[i])) {
                    Boolean actual = trie.startsWith(test.in2[i]);
                    assert Objects.equals(test.expected[i], actual) : "startsWith('%s') == %s, want %s"
                            .formatted(test.in2[i], actual, test.expected);
                } else {
                    throw new IllegalArgumentException("Unexpected method '%s'".formatted(test.in1[i]));
                }
            }
        }
    }

}