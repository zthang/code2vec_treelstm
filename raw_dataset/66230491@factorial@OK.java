private int factorial(int n) {
    long fac = 1;
    for (int i = 2; i <= n; i++) {
        fac *= i;
        fac %= mod;
    }
    return (int) (fac % mod);
}