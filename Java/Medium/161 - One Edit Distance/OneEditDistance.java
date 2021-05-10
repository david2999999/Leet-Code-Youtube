public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        if (Math.abs(s.length() - t.length()) > 1) return false;

        if (s.length() == t.length()) {
            return hasOneReplacement(s, t);
        } else {
            return hasOneModification(s, t);
        }
    }

    private boolean hasOneModification(String s, String t) {
        String shorter = s.length() < t.length() ? s : t;
        String longer = s.length() < t.length() ? t : s;
        int i = 0, j = 0;

        while (i < shorter.length() && j < longer.length()) {
            if (shorter.charAt(i) != longer.charAt(j)) {
                if (i != j) return false;

                j++;
            } else {
                i++; j++;
            }
        }

        return true;
    }

    private boolean hasOneReplacement(String s, String t) {
        int diff = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) diff++;
        }

        return diff == 1;
    }
}