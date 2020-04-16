public static long GCD(long a, long b) {
    if (b == 0)
        return a;
    if (a == 0)
        return b;
    return (a > b) ? GCD(a % b, b) : GCD(a, b % a);
}