static long __gcd(long a, long b) {
    if (b == 0) {
        return a;
    } else {
        return __gcd(b, a % b);
    }
}