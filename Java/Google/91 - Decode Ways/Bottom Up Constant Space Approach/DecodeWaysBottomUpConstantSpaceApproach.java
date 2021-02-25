public class DecodeWaysBottomUpConstantSpaceApproach {
    public int numDecodings(String s) {
        int ways1 = 1, ways2 = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int ways = 0;
            int num1 = Character.getNumericValue(s.charAt(i));
            int num2 = (i != s.length() - 1) ?
                    Character.getNumericValue(s.charAt(i)) * 10 + Character.getNumericValue(s.charAt(i + 1)) : 0;

            if (num1 >= 1 && num1 <= 9) {
                ways += ways1;
            }

            if (num2 >= 10 && num2 <= 26) {
                ways += ways2;
            }

            ways2 = ways1;
            ways1 = ways;
        }

        return ways1;
    }
}