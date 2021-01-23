public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        s = s.toLowerCase();

        while (i < j) {
            char c = s.charAt(i), d = s.charAt(j);

            if (!isAlphanumeric(c)) {
                i++;
                continue;
            }

            if (!isAlphanumeric(d)) {
                j--;
                continue;
            }

            if (c != d) return false;

            i++; j--;
        }

        return true;
    }

    private boolean isAlphanumeric(char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }
}