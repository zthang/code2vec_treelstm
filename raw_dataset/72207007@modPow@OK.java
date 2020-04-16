static long modPow(long a, long e) {
    long res = 1;
    while (e > 0) {
        if ((e & 1) == 1)
            res = (res * a) % mod;
        a = (a * a) % mod;
        e >>= 1;
    }
    return res;
}