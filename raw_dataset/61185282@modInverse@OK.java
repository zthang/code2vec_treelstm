static long modInverse(long n, int M) {
    return fast_pow(n, M - 2, M);
}