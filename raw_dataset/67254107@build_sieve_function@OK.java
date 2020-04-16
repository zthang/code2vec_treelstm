private void build_sieve_function(int n) {
    sieve = new int[n + 1];
    for (int i = 2; i <= n; i++) sieve[i] = i;
    for (int i = 2; i <= n; i++) {
        if (sieve[i] == i) {
            for (long j = 1L * i * i; j <= n; j += i) sieve[(int) j] = i;
        }
    }
}