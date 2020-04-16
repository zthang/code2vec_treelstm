static long fac(int n) {
    if (n == 0)
        return fac[n] = 1;
    if (n == 1)
        return fac[n] = 1;
    long ans = 1;
    for (int i = 1; i <= n; i++) fac[i] = ans = (i % mod * ans % mod) % mod;
    return ans % mod;
}