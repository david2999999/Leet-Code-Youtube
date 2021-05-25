public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int zeroes = 0, multiple = 5;

        while (multiple <= n) {
            zeroes += (n / multiple);
            multiple *= 5;
        }

        return zeroes;
    }
}