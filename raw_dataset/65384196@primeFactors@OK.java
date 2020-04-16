static long primeFactors(long n) {
    long m = n;
    if (n % 2 == 0) {
        m -= n / 2;
    }
    while (n % 2 == 0) {
        n /= 2;
    }
    for (int i = 3; i <= Math.sqrt(n); i += 2) {
        while (n % i == 0) {
            m -= n / i;
            n /= i;
        }
    }
    if (n > 2)
        return m - n / n;
    return m + 1;
}