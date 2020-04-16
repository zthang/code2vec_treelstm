static void perm() {
    fac[0] = 1;
    for (int x = 1; x <= 1000000; x++) fac[x] = fac[x - 1] * x;
}