public boolean isPrime(long n) {
    if (n < 2)
        return false;
    for (long x = 2; x * x <= n; x++) {
        if (n % x == 0)
            return false;
    }
    return true;
}