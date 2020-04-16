static long pow(long a, long b, long c) {
    if (b == 0) {
        return 1;
    }
    long d = pow(a, b / 2, c);
    d = (d * d) % c;
    if (b % 2 == 1) {
        d = (d * a) % c;
    }
    return d;
}