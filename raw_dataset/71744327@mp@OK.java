long mp(long b, long e) {
    long r = 1;
    while (e > 0) {
        if ((e & 1) == 1)
            r = (r * b) % mod;
        b = (b * b) % mod;
        e >>= 1;
    }
    return r;
}