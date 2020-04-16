public static void sieve(boolean[] isPrime, int n) {
    for (int i = 1; i < n; i++) isPrime[i] = true;
    isPrime[0] = false;
    isPrime[1] = false;
    for (int i = 2; i * i < n; i++) {
        if (isPrime[i] == true) {
            for (int j = (2 * i); j < n; j += i) isPrime[j] = false;
        }
    }
}