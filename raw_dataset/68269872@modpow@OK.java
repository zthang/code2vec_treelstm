static long modpow(long a, long b) {
    if (b == 0)
        return 1;
    long x = modpow(a, b / 2);
    x = (x * x) % mod;
    if (b % 2 == 1)
        return (x * a) % mod;
    return x;
}