public class DecodeWaysRecursiveApproach {
    public int numDecodings(String s) {
        return numDecodings(0, s);
    }

    private int numDecodings(int i, String s) {
        if (i >= s.length()) return 1;

        int ways = 0;
        int num1 = Character.getNumericValue(s.charAt(i));
        int num2 = (i != s.length() - 1) ?
                Character.getNumericValue(s.charAt(i)) * 10 + Character.getNumericValue(s.charAt(i + 1)) : 0;

        if (num1 >= 1 && num1 <= 9) {
            ways += numDecodings(i + 1, s);
        }

        if (num2 >= 10 && num2 <= 26) {
            ways += numDecodings(i + 2, s);
        }

        return ways;
    }
}
}