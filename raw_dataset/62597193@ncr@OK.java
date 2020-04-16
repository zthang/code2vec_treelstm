public long ncr(int n, int r) {
    if (r > n)
        return 0;
    if (factorial == null)
        setFactorial();
    long numerator = factorial[n];
    long denominator = factorial[r] * factorial[n - r] % MOD;
    return numerator * pow(denominator, MOD - 2, MOD) % MOD;
}