public static long modPow(long a, long n, long MOD) {
    long S = 1;
    for (; n > 0; n >>= 1, a = (a * a) % MOD) if ((n & 1) != 0)
        S = (a * S) % MOD;
    return S;
}