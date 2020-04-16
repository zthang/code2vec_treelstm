// O(Log m) whem m is prime (fermat's little theorem)
int modInverse(// O(Log m) whem m is prime (fermat's little theorem)
int a, // O(Log m) whem m is prime (fermat's little theorem)
int m) {
    if (gcd(a, m) != 1) {
        return -1;
    } else {
        return power(a, m - 2, m);
    }
}