static long pow(long a, long b) {
    if (b == 0)
        return 1L;
    long val = pow(a, b / 2);
    if (b % 2 == 0)
        return val * val % mod;
    else
        return val * val % mod * a % mod;
}