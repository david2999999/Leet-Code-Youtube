public class WordDictionary {
    private class TrieNode {
        public Map<Character, TrieNode> children;
        public boolean isWord = false;

        public TrieNode() {
            this.children = new HashMap<>();
        }
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
        }

        node.isWord = true;
    }

    public boolean search(String word) {
        return search(word, 0, root);
    }

    private boolean search(String word, int i, TrieNode node) {
        if (i >= word.length() && node.isWord) return true;

        for (int j = i; j < word.length(); j++) {
            char c = word.charAt(j);

            if (c == '.') {
                for (TrieNode child: node.children.values()) {
                    if (search(word, j + 1, child)) return true;
                }
            }

            if (!node.children.containsKey(c)) return false;

            node = node.children.get(c);
        }

        return node.isWord;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */