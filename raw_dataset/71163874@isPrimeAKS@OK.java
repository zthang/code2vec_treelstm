private static boolean isPrimeAKS(long n) {
    if (n % mod == 0 || n < 2)
        return false;
    if (n > 2 && n % 2 == 0)
        return false;
    return (power((mod - 1), n, n) == (power(mod, n, n) - 1 + n) % n);
}