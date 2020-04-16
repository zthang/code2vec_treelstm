static void sieveOfEratosthenes(int n) {
    // Create a boolean array "prime[0..n]" and initialize
    // all entries it as true. A value in prime[i] will
    // finally be false if i is Not a prime, else true.
    int pos = 0;
    prime = new int[n + 1];
    for (int p = 2; p * p <= n; p++) {
        // If prime[p] is not changed, then it is a prime
        if (prime[p] == 0) {
            // Update all multiples of p
            prime[p] = p;
            for (int i = p * p; i <= n; i += p) prime[i] = p;
        }
    }
}