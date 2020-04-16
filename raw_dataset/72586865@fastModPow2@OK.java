private static long fastModPow2(long x, int n, int mod) {
    if (n == 0) {
        return 1;
    }
    long coeff = 1, base = x;
    while (n > 1) {
        if (n % 2 != 0) {
            coeff = (coeff * base % mod);
        }
        base = (base * base % mod);
        n = n / 2;
    }
    long res = coeff * base % mod;
    return res;
}