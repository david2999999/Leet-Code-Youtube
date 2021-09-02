public class ReverseVowelsOfString {
    private static final String VOWELS = "aeiouAEIOU";

    public String reverseVowels(String s) {
        StringBuilder str = new StringBuilder();
        int j = s.length() - 1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!isVowel(c)) {
                str.append(c);
                continue;
            }

            while (!isVowel(s.charAt(j))) j--;

            str.append(s.charAt(j--));
        }

        return str.toString();
    }

    private boolean isVowel(char c) {
        return VOWELS.indexOf(c) != -1;
    }
}