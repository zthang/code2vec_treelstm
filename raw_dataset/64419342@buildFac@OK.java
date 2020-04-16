void buildFac() {
    fac = new long[10000003];
    revfac = new long[10000003];
    fac[0] = 1;
    for (int i = 1; i <= 10000002; i++) {
        fac[i] = (fac[i - 1] * i) % mod;
    }
    revfac[10000002] = rev(fac[10000002]) % mod;
    for (int i = 10000001; i >= 0; i--) {
        revfac[i] = (revfac[i + 1] * (i + 1)) % mod;
    }
    isBuild = true;
}