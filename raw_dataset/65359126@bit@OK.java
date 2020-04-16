static int bit(long n) throws IOException {
    return (n == 0) ? 0 : (1 + bit(n & (n - 1)));
}