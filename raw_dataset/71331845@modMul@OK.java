public static long modMul(long a, long b, long mod) {
    return ((a % mod) * (b % mod)) % mod;
}