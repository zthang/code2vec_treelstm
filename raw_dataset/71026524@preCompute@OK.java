private static void preCompute() {
    fac[0] = ifac[0] = fac[1] = ifac[1] = 1;
    int i;
    for (i = 2; i < 2000005; i++) {
        fac[i] = (i * fac[i - 1]) % mod;
        ifac[i] = (power(i, mod - 2) * ifac[i - 1]) % mod;
    }
}