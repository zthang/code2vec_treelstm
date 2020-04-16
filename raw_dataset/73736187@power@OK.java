int power(long x, long y, int m) {
    // log(y)
    if (y == 0) {
        return 1;
    }
    long p = power(x, y / 2, m) % m;
    p = (p * p) % m;
    return (int) ((y % 2 == 0) ? p : (x * p) % m);
}