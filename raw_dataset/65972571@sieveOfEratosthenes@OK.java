public int[] sieveOfEratosthenes(int n) {
    // Returns an array with the smallest prime factor for each number and primes marked as 0
    int[] sieve = new int[n + 1];
    for (int x = 2; x * x <= n; x++) {
        if (sieve[x] != 0)
            continue;
        for (int u = x * x; u <= n; u += x) {
            if (sieve[u] == 0) {
                sieve[u] = x;
            }
        }
    }
    return sieve;
}