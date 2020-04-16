public static long ceilMod(long a, long b) {
    return a - ceilDiv(a, b) * b;
}