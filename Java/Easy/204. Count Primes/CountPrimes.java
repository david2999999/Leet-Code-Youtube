public class CountPrimes {
    public int countPrimes(int n) {
        if (n == 0 || n == 1) return 0;

        boolean[] isPrime = createTable(n);
        int primes = 0;

        for (boolean p: isPrime) {
            if (p) primes++;
        }

        return primes;
    }

    private boolean[] createTable(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i <= n / 2; i++) {
            if (!isPrime[i]) continue;

            for (int j = 2; i * j < n; j++) {
                isPrime[i * j] = false;
            }
        }

        return isPrime;
    }
}