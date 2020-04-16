static long fact(long n) {
    long f = 1L;
    for (long i = 2; i <= n; i++) {
        f = (f * i) % mod;
    }
    return f;
}