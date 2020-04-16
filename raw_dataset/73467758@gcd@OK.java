public static long gcd(long a, long b) {
    long buf = a;
    a = Math.min(a, b);
    b = Math.max(buf, b);
    if (a == 0)
        return b;
    return gcd(a, b % a);
}