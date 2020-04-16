// O(log(max(A,M)))
static long modInverse(long a, long m) {
    extendedEuclid(a, m);
    return (x % m + m) % m;
}