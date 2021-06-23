public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int ones = 0;

        while (n != 0) {
            n = n & (n - 1);
            ones++;
        }

        return ones;
    }
}