public static long GCD(long n, long m) {
    if (m == 0)
        return n;
    else
        return GCD(m, n % m);
}