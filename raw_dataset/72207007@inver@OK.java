static long inver(long x) {
    long a = x;
    long e = (mod - 2);
    long res = 1;
    while (e > 0) {
        if ((e & 1) == 1) {
            res = ((1l * res * a) % mod);
        }
        a = ((1l * a * a) % mod);
        e >>= 1;
    }
    return res % mod;
}