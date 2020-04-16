static long ncr(int n, int r) {
    if (n < r) {
        return 0;
    }
    if (r > n - r) {
        r = n - r;
    }
    long num = 1;
    long den = 1;
    for (int i = 1; i <= r; i++) {
        num *= n - i + 1;
        den *= i;
        long temp = gcd(num, den);
        num /= temp;
        den /= temp;
    }
    return num / den;
}