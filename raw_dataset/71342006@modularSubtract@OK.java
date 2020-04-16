private static long modularSubtract(long a, long b, int mod) {
    long diff = a - b;
    if (diff < 0) {
        diff += mod;
    }
    return diff;
}