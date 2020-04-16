public long pow(long a, long b) {
    if (b == 0) {
        return 1;
    }
    long v = pow(mul(a, a), b / 2);
    if (b % 2 == 1) {
        return mul(v, a);
    } else {
        return v;
    }
}