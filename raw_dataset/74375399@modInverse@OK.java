// Returns n^(-1) mod p
static long modInverse(long n, long p) {
    return power(n, p - 2, p);
}