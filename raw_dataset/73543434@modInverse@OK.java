static long modInverse(long n, long M) {
    return fast_pow(n, M - 2, M);
}