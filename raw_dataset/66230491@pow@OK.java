private static int pow(int base, int exp) {
    if (exp == 0) {
        return 1;
    } else if (exp == 1) {
        return base;
    }
    int a = pow(base, exp / 2);
    a = ((a % mod) * (a % mod)) % mod;
    if (exp % 2 == 1) {
        a = ((a % mod) * (base % mod));
    }
    return a;
}