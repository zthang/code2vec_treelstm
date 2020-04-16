// Euclidean Algorithm
static long gcd(long A, long B) {
    return (B == 0) ? A : gcd(B, A % B);
}