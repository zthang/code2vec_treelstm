public static void getPrimes(ArrayList<Integer> primes, int N) {
    // get all primes less than or equal to N, (O(n)
    boolean[] sieve = new boolean[N + 1];
    for (int i = 2; i <= N; i++) {
        if (!sieve[i]) {
            primes.add(i);
        }
        for (int j = 0; j < primes.size() && primes.get(j) * i <= N; j++) {
            sieve[primes.get(j) * i] = true;
            if (i % primes.get(j) == 0) {
                break;
            }
        }
    }
}