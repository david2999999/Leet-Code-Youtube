public class DecodeWaysMemoizationApproach {
    public int numDecodings(String s) {
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return numDecodings(0, s, memo);
    }

    private int numDecodings(int i, String s, int[] memo) {
        if (i >= s.length()) return 1;
        if (memo[i] != -1) return memo[i];

        int ways = 0;
        int num1 = Character.getNumericValue(s.charAt(i));
        int num2 = (i != s.length() - 1) ?
                Character.getNumericValue(s.charAt(i)) * 10 + Character.getNumericValue(s.charAt(i + 1)) : 0;

        if (num1 >= 1 && num1 <= 9) {
            ways += numDecodings(i + 1, s, memo);
        }

        if (num2 >= 10 && num2 <= 26) {
            ways += numDecodings(i + 2, s, memo);
        }

        return memo[i] = ways;
    }
}