public class WordBreakRecursiveApproach {
    private class TrieNode {
        public Map<Character, TrieNode> children;
        public boolean isWord = false;

        public TrieNode() {
            this.children = new HashMap<>();
        }
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        TrieNode root = createTrie(wordDict);
        return wordBreak(0, s, root);
    }

    private boolean wordBreak(int i, String s, TrieNode root) {
        if (i >= s.length()) return true;

        TrieNode node = root;

        for (int j = i; j < s.length(); j++) {
            char c = s.charAt(j);

            if (!node.children.containsKey(c)) break;

            node = node.children.get(c);

            if (node.isWord && wordBreak(j + 1, s, root)) return true;
        }

        return false;
    }

    private TrieNode createTrie(List<String> wordDict) {
        TrieNode root = new TrieNode();

        for (String word: wordDict) {
            TrieNode node = root;

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                node.children.putIfAbsent(c, new TrieNode());
                node = node.children.get(c);
            }

            node.isWord = true;
        }

        return root;
    }
}