public class WordBreakBottomUpApproach {
    private class TrieNode {
        public Map<Character, TrieNode> children;
        public boolean isWord = false;

        public TrieNode() {
            this.children = new HashMap<>();
        }
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        TrieNode root = createTrie(wordDict);
        boolean[] canBreak = new boolean[s.length() + 1];

        for (int i = s.length(); i >= 0; i--) {
            if (i == s.length()) {
                canBreak[i] = true;
                continue;
            }

            TrieNode node = root;

            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);

                if (!node.children.containsKey(c)) break;

                node = node.children.get(c);

                if (node.isWord && canBreak[j + 1]) {
                    canBreak[i] = true;
                    break;
                }
            }
        }

        return canBreak[0];
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