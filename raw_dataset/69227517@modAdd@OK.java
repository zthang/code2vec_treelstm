public static long modAdd(long a, long b, long mod) {
    return (a % mod + b % mod) % mod;
}