int bit(long n) {
    return (n == 0) ? 0 : (1 + bit(n & (n - 1)));
}