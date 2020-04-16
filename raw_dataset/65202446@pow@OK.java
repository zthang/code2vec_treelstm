static long pow(long a, long n, long mod) {
    if (n == 0)
        return 1;
    if (n % 2 == 1)
        return a * pow(a, n - 1, mod) % mod;
    long x = pow(a, n / 2, mod);
    return x * x % mod;
}