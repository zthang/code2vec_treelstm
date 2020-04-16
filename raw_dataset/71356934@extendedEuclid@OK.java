private static void extendedEuclid(long a, long b) {
    if (b == 0) {
        gcdx = a;
        x = 1;
        y = 0;
    } else {
        extendedEuclid(b, a % b);
        long temp = x;
        x = y;
        y = temp - ((a / b) * y);
    }
}