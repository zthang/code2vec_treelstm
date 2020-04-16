// To compute x^y under modulo m
static long power(long x, long y, long p) {
    // Initialize result
    long res = 1;
    // Update x if it is more than or
    // equal to p
    x = x % p;
    while (y > 0) {
        // with result
        if (y % 2 == 1)
            res = (res * x) % p;
        // y must be even now
        // y = y/2
        y = y >> 1;
        x = (x * x) % p;
    }
    return res;
}