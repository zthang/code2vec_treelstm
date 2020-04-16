public long pow(long x, long p) {
    if (p == 0) {
        return 1;
    }
    long t = pow(x, p / 2);
    t *= t;
    t %= mod;
    if (p % 2 == 1) {
        t *= x;
        t %= mod;
    }
    return t;
}