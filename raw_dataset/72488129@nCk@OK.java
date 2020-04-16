long nCk(int n, int k) {
    if (n < k) {
        return 0;
    }
    if (n < 0 || k < 0) {
        return 0;
    }
    return fac[n] * (finv[k] * finv[n - k] % mod) % mod;
}