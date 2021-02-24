public class DecodeWaysBottomUpArrayApproach {
    public int numDecodings(String s) {
        int[] ways = new int[s.length() + 1];

        for (int i = s.length(); i >= 0; i--) {
            if (i == s.length()) {
                ways[i] = 1;
                continue;
            }

            int num1 = Character.getNumericValue(s.charAt(i));
            int num2 = (i != s.length() - 1) ?
                    Character.getNumericValue(s.charAt(i)) * 10 + Character.getNumericValue(s.charAt(i + 1)) : 0;

            if (num1 >= 1 && num1 <= 9) {
                ways[i] += ways[i + 1];
            }

            if (num2 >= 10 && num2 <= 26) {
                ways[i] += ways[i + 2];
            }
        }

        return ways[0];
    }
}