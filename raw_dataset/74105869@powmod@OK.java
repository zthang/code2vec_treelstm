private static long powmod(long x, long n) {
    if (n == 0 || x == 0)
        return 1;
    else if (n % 2 == 0)
        return (powmod((x * x) % MOD, n / 2));
    else
        return (x * (powmod((x * x) % MOD, (n - 1) / 2))) % MOD;
}