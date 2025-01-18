import java.util.Arrays;

class Trie {

    private static class TrieNode {

        private boolean isEndOfWord;
        private final TrieNode[] children;

        TrieNode() {
            super();
            this.isEndOfWord = false;
            this.children = new TrieNode[26];
        }

        @Override
        public String toString() {
            return "TrieNode [isEndOfWord=" + isEndOfWord + ", children=" + Arrays.toString(children) + "]";
        }

    }

    private final TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            if (current.children[ch - 'a'] == null) {
                current.children[ch - 'a'] = new TrieNode();
            }
            current = current.children[ch - 'a'];
        }
        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            if (current.children[ch - 'a'] == null) {
                return false;
            }
            current = current.children[ch - 'a'];
        }
        return current != null && current.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (char ch : prefix.toCharArray()) {
            if (current.children[ch - 'a'] == null) {
                return false;
            }
            current = current.children[ch - 'a'];
        }
        return true;
    }

    @Override
    public String toString() {
        return "Trie [root=" + root + "]";
    }

}
