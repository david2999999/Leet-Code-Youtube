public class WordBreakMemoizationApproach {
    private class TrieNode {
        public Map<Character, TrieNode> children;
        public boolean isWord = false;

        public TrieNode() {
            this.children = new HashMap<>();
        }
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        TrieNode root = createTrie(wordDict);
        return wordBreak(0, s, root, new Boolean[s.length()]);
    }

    private boolean wordBreak(int i, String s, TrieNode root, Boolean[] memo) {
        if (i >= s.length()) return true;
        if (memo[i] != null) return memo[i];

        TrieNode node = root;

        for (int j = i; j < s.length(); j++) {
            char c = s.charAt(j);

            if (!node.children.containsKey(c)) break;

            node = node.children.get(c);

            if (node.isWord && wordBreak(j + 1, s, root, memo)) return memo[i] = true;
        }

        return memo[i] = false;
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