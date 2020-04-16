long modInv(long a, long m) {
    return modPow(a, m - 2, m);
}