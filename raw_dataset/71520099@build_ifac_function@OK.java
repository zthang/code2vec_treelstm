private void build_ifac_function(int n) {
    ifac = new int[n + 1];
    ifac[0] = 1;
    for (int i = 1; i <= n; i++) ifac[i] = (int) (1L * ifac[i - 1] * inv(i) % MOD);
}