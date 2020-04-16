void pre(int nmax, int nmod) {
    fac = new long[nmax];
    finv = new long[nmax];
    inv = new long[nmax];
    fac[0] = fac[1] = 1;
    finv[0] = finv[1] = 1;
    inv[1] = 1;
    for (int i = 2; i < nmax; i++) {
        fac[i] = fac[i - 1] * i % nmod;
        inv[i] = nmod - inv[nmod % i] * (nmod / i) % nmod;
        finv[i] = finv[i - 1] * inv[i] % nmod;
    }
}