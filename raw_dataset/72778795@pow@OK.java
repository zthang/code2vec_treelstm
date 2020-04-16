static long pow(long a, long b) {
    long res = 1;
    while (b > 0) {
        if ((b & 1) != 0) {
            res = (res * a) % MOD;
        }
        a = (a * a) % MOD;
        b >>= 1;
    }
    return res;
}