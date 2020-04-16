// Returns n^(-1) mod p
static int modInverse(int n, int p) {
    return power(n, p - 2, p);
}