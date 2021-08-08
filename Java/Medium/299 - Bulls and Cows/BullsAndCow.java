public class BullsAndCow {
    public String getHint(String secret, String guess) {
        Map<Character, Integer> map = new HashMap<>();
        int bulls = 0, cows = 0;

        for (int i = 0; i < secret.length(); i++) {
            char c = secret.charAt(i), d = guess.charAt(i);

            if (c == d) {
                bulls++;
            } else {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }

        for (int i = 0; i < guess.length(); i++) {
            char c = secret.charAt(i), d = guess.charAt(i);

            if (c == d) continue;

            if (map.containsKey(d) && map.get(d) > 0) {
                cows++;
                map.put(d, map.get(d) - 1);
            }
        }

        return new StringBuilder().
            append(bulls).append("A").
            append(cows).append("B").
            toString();
    }
}