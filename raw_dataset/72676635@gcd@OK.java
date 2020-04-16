public static long gcd(long a, long b) {
    long t;
    while (b != 0) {
        t = b;
        b = a % b;
        a = t;
    }
    return a;
}