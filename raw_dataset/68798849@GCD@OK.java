public static long GCD(long a, long b) {
    if (b == 0)
        return a;
    else
        return GCD(b, a % b);
}