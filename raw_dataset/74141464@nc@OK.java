static long nc(int n, int r) {
    if (n < r)
        return 0;
    long v = fac[n];
    v *= Pow(fac[r], mod - 2, mod);
    v %= mod;
    v *= Pow(fac[n - r], mod - 2, mod);
    v %= mod;
    return v;
}