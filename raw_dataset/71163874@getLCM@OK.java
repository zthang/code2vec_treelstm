private static long getLCM(long a, long b) {
    return (Math.max(a, b) / gcd(a, b)) * Math.min(a, b);
}