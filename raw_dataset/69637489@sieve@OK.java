static void sieve() {
    for (int i = 0; i < 1000001; i++) prime[i] = true;
    for (int p = 2; p * p <= 1000000; p++) {
        // If prime[p] is not changed, then it is a prime
        if (prime[p] == true) {
            // Update all multiples of p
            for (int i = p * p; i <= 1000000; i += p) prime[i] = false;
        }
    }
    // Print all prime numbers
    for (int i = 2; i <= 1000000; i++) {
    // if(prime[i] == true)
    }
}