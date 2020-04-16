public static long numberOfBits(long n) {
    long count = 0;
    while (n > 0) {
        count++;
        n >>= 1;
    }
    return count;
}