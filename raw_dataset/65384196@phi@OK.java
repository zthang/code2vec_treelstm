static long phi(long n) {
    long result = n;
    long m = n;
    for (long p = 2; p * p <= n; ++p) {
        if (n % p == 0) {
            while (n % p == 0) n /= p;
            result -= result / p;
        }
    }
    if (n > 1)
        result -= result / n;
    if (result == m - 1)
        result++;
    return result;
}