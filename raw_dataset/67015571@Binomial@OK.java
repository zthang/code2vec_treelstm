public static long Binomial(long N, long R, long p) {
    long ans = ((fact[(int) N] * factorialNumInverse[(int) R]) % p * factorialNumInverse[(int) (N - R)]) % p;
    return ans;
}