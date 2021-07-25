public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        return Arrays.equals(getFrequency(s), getFrequency(t));
    }

    private int[] getFrequency(String s) {
        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        return count;
    }
}