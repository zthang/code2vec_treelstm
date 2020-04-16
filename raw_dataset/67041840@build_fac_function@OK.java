private void build_fac_function(int n) {
    fac = new int[n + 1];
    fac[0] = 1;
    for (int i = 1; i <= n; i++) fac[i] = (int) (1L * fac[i - 1] * i % MOD);
}