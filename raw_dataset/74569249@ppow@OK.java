public long ppow(long a, long b, long mod) {
    if (b == 0L)
        return 1L;
    long tmp = 1;
    while (b > 1L) {
        if ((b & 1L) == 1)
            tmp *= a;
        a *= a;
        a %= mod;
        tmp %= mod;
        b >>= 1;
    }
    return (tmp * a) % mod;
}