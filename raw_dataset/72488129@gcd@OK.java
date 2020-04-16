static long gcd(long c, long d) {
    while (true) {
        long f = c % d;
        if (f == 0) {
            return d;
        }
        c = d;
        d = f;
    }
}