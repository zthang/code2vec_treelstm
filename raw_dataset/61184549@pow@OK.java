public static long pow(long a, long b) {
    long result = 1;
    while (b > 0) {
        if (b % 2 != 0) {
            result = (result * a) % 998244353;
            b--;
        }
        a = (a * a) % 998244353;
        b /= 2;
    }
    return result;
}