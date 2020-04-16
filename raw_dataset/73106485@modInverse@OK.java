public static long modInverse(long a, long MOD) {
    long[] gcdE = gcdExtended(a, MOD);
    // Inverted doesn't exist
    if (gcdE[0] != 1)
        return -1;
    long x = gcdE[1];
    return (x % MOD + MOD) % MOD;
}