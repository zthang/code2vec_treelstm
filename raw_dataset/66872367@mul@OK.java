static long mul(long a, long b, long p) {
    long res = 0, base = a;
    while (b > 0) {
        if ((b & 1L) > 0)
            res = (res + base) % p;
        base = (base + base) % p;
        b >>= 1;
    }
    return res;
}