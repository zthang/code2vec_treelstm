static long phi(long n) {
    long result = n;
    for (int i = 2; i <= Math.sqrt(n); i++) {
        if (n % i == 0) {
            result -= result / i;
        }
        while (n % i == 0) {
            n = n / i;
        }
    }
    if (n > 1) {
        result -= (result / n);
    }
    return result;
}