public static boolean isMultiplicationOverflow(long a, long b, long limit) {
    if (limit < 0) {
        limit = -limit;
    }
    if (a < 0) {
        a = -a;
    }
    if (b < 0) {
        b = -b;
    }
    if (a == 0 || b == 0) {
        return false;
    }
    // a * b > limit => a > limit / b
    return a > limit / b;
}