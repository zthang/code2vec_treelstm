// Modular Exponentiation
static long fastExpo(long x, long n) {
    if (n == 0)
        return 1;
    if ((n & 1) == 0)
        return fastExpo((x * x) % MOD, n / 2) % MOD;
    return ((x % MOD) * fastExpo((x * x) % MOD, (n - 1) / 2)) % MOD;
}