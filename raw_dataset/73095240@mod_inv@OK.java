public static long mod_inv(long n, long mod) {
    return pow(n, mod - 2, mod);
}