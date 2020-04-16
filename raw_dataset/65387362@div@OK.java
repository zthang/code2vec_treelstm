static long div(long a, long b, long m) {
    long r = 1l;
    a %= m;
    while (b > 0) {
        if ((b & 1) == 1)
            r = (r * a) % m;
        b >>= 1;
        a = (a * a) % m;
    }
    return r;
}