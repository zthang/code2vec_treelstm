public static long largestDivisor(long n) {
    long divisor = 0;
    long w = n >> 1;
    for (int i = 1; i <= w; i++) if (n % i == 0)
        divisor = i;
    return divisor;
}