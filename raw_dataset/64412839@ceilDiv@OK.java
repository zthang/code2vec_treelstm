public static long ceilDiv(long a, long b) {
    return Math.floorDiv(a + b - 1, b);
}