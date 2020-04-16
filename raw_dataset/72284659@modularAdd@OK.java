private static long modularAdd(long a, long b, int mod) {
    long sum = a + b;
    if (sum >= mod) {
        sum -= mod;
    }
    return sum;
}