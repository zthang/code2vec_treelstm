public static long fastPow(int base, long exp) {
    if (exp == 0) {
        return 1;
    } else {
        if (exp % 2 == 1) {
            long z = fastPow(base, (exp - 1) / 2);
            return ((((z * base)) * z));
        } else {
            long z = fastPow(base, exp / 2);
            return ((z * z));
        }
    }
}