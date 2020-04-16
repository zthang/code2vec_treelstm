static long nCrModPFermat(int n, int r, int p, long[] fac) {
    // Base case
    if (r == 0)
        return 1;
    // Fill factorial array so that we
    // can find all factorial of r, n
    // and n-r
    long t = (fac[n] * modInverse(fac[r], p)) % p;
    return ((t * modInverse(fac[n - r], p)) % p);
}