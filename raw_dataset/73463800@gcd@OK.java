private long gcd(long a, long b) {
    while (a != 0) {
        long tmp = b % a;
        b = a;
        a = tmp;
    }
    return b;
}