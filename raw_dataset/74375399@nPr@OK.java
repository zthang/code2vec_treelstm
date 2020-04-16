// Returns nCr % p using Fermat's
// little theorem.
static long nPr(int n, int r, long p) {
    // Base case
    if (r == 0)
        return 1;
    return ((fac[n] % p) * modInverse(fac[n - r], p) % p) % p;
}