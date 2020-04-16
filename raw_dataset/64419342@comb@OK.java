public long comb(int a, int num) {
    if (a - num < 0)
        return 0;
    if (num < 0)
        return 0;
    if (!isBuild)
        buildFac();
    return fac[a] * ((revfac[num] * revfac[a - num]) % mod) % mod;
}