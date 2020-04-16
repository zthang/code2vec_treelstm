static long mpow(long a, long b) {
    long res = 1;
    while (b > 0) {
        if ((b & 1) == 1)
            res = ((res % mod) * (a % mod)) % mod;
        b >>= 1;
        a = ((a % mod) * (a % mod)) % mod;
    }
    return res;
}