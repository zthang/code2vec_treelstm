private static long C(int n, int r) {
    return (fac[n] * ((ifac[r] * ifac[n - r]) % mod)) % mod;
}