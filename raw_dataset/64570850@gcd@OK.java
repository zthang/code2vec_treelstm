/**
 * *****************************************GCD*********************************************************
 */
static long gcd(long x, long y) {
    if (x == 0)
        return y;
    if (y == 0)
        return x;
    long r = 0, a, b;
    // a is greater number
    a = (x > y) ? x : y;
    // b is smaller number
    b = (x < y) ? x : y;
    r = b;
    while (a % b != 0) {
        r = a % b;
        a = b;
        b = r;
    }
    return r;
}