public long perm(int a, int num) {
    if (!isBuild)
        buildFac();
    return fac[a] * (rev(fac[a - num])) % mod;
}