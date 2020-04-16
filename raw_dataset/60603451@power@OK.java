// To compute x^y under modulo m
static long power(long x, long y, long m) {
    if (y == 0)
        return 1;
    long p = power(x, y / 2, m) % m;
    p = (p * p) % m;
    if (y % 2 == 0)
        return p;
    else
        return (x * p) % m;
}