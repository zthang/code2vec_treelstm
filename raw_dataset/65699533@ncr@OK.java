public static long ncr(long n) {
    if (n < 2)
        return 0;
    return (n * (n - 1)) / 2;
}