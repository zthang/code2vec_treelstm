public static int digit(long n) {
    int result = 0;
    while (n > 0) {
        n /= 10;
        result++;
    }
    return result;
}