static long fastexpo(long x, long y) {
    long res = 1;
    while (y > 0) {
        if ((y & 1) == 1) {
            res *= x;
        }
        y = y >> 1;
        x = x * x;
    }
    return res;
}