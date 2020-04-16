static long binpow(long a, long b) {
    long res = 1;
    while (b > 0) {
        if ((b & 1) != 0)
            res = res * a;
        a = a * a;
        b >>= 1;
    }
    return res;
}