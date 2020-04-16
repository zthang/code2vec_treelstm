public static long pow(long a, long b) {
    long result = 1;
    while (b > 0) {
        if (b % 2 != 0) {
            result = (result * a) % 1000000007;
            b--;
        }
        a = (a * a) % 1000000007;
        b /= 2;
    }
    return result;
}