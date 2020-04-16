long gen(long x) {
    while (true) {
        long f = rd.nextLong() % x;
        if (f >= 1 && f <= x - 1) {
            return f;
        }
    }
}