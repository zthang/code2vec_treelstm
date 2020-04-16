public static long pow(long a, long b) {
    if (b == 0) {
        return 1;
    }
    if (b == 1) {
        return a;
    }
    long val = pow(a, b / 2);
    if (b % 2 == 0) {
        return val * val;
    } else {
        return val * (val * a);
    }
}