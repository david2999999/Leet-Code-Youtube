public class Trie {
    private class TrieNode {
        public Map<Character, TrieNode> children;
        public boolean isWord = false;

        public TrieNode() {
            this.children = new HashMap<>();
        }
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        this.root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
        }

        node.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (!node.children.containsKey(c)) return false;

            node = node.children.get(c);
        }

        return node.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;

        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);

            if (!node.children.containsKey(c)) return false;

            node = node.children.get(c);
        }

        return true;
    }
}