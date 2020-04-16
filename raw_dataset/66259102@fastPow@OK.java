public static long fastPow(int base, long exp, int mod) {
    if (exp == 0) {
        return 1;
    } else {
        if (exp % 2 == 1) {
            long z = fastPow(base, (exp - 1) / 2, mod);
            return ((((z * base) % mod) * z) % mod);
        } else {
            long z = fastPow(base, exp / 2, mod);
            return ((z * z) % mod);
        }
    }
}