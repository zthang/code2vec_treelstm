public void setSieve() {
    primes = new ArrayList<>();
    sieve = new int[MAXN];
    int i, j;
    for (i = 2; i < MAXN; ++i) if (sieve[i] == 0) {
        primes.add(i);
        for (j = i; j < MAXN; j += i) {
            sieve[j] = i;
        }
    }
}