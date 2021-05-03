public class LongestSubstringWithAtMostTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, length = 0;

        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            map.put(c, map.getOrDefault(c, 0) + 1);

            while (map.size() > 2) {
                char d = s.charAt(i++);
                map.put(d, map.get(d) - 1);

                if (map.get(d) == 0) map.remove(d);
            }

            length = Math.max(length, j - i + 1);
        }

        return length;
    }
}