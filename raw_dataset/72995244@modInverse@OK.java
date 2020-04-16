// Function to find modular
// inverse of a under modulo m
// Assumption: m is prime
static long modInverse(long a, int m) {
    if (__gcd(a, m) != 1) {
        // System.out.print("Inverse doesn't exist");
        return -1;
    } else {
        // +power(a, m - 2, m));
        return power(a, m - 2, m);
    }
}