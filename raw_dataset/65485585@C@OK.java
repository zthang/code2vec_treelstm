long C(long n, long m, long MOD) {
    if (m + m > n)
        m = n - m;
    long up = 1, down = 1;
    for (long i = 0; i < m; i++) {
        up = up * (n - i) % MOD;
        down = down * (i + 1) % MOD;
    }
    return up * inv(down, MOD) % MOD;
}