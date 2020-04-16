/**
 * ***************************************SIEVE*********************************************************
 */
static void sieveMake(int n) {
    sieve = new boolean[n];
    Arrays.fill(sieve, true);
    sieve[0] = false;
    sieve[1] = false;
    for (int i = 2; i * i < n; i++) {
        if (sieve[i]) {
            for (int j = i * i; j < n; j += i) {
                sieve[j] = false;
            }
        }
    }
    primes = new ArrayList<Integer>();
    for (int i = 0; i < n; i++) {
        if (sieve[i]) {
            primes.add(i);
        }
    }
}