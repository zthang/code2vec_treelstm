static long product(long x) {
    long prod = 1;
    while (x > 0) {
        prod *= (x % 10);
        x /= 10;
    }
    return prod;
}