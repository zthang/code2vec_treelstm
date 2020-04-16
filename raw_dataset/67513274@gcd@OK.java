// Euclidean Algorithm
static long gcd(long A, long B) {
    if (B == 0)
        return A;
    return gcd(B, A % B);
}