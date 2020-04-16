public long ModPow(long x, long y, long MOD) {
    long res = 1L;
    x = x % MOD;
    while (y >= 1) {
        if ((y & 1) > 0)
            res = (res * x) % MOD;
        x = (x * x) % MOD;
        y >>= 1;
    }
    return res;
}