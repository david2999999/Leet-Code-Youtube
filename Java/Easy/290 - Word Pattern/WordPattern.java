public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");

        if (words.length != pattern.length()) return false;

        Map<Character, String> map = new HashMap<>();
        Set<String> seen = new HashSet<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            if (!map.containsKey(c)) {
                if (seen.contains(word)) return false;

                map.put(c, word);
                seen.add(word);
            } else {
                if (!map.get(c).equals(word)) return false;
            }
        }

        return true;
    }
}