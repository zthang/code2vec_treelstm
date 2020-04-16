static void extendedEuclid(long a, long b) {
    if (b == 0) {
        xe = 1;
        ye = 0;
        d = a;
        return;
    }
    extendedEuclid(b, a % b);
    long x1 = ye;
    long y1 = xe - a / b * ye;
    xe = x1;
    ye = y1;
}