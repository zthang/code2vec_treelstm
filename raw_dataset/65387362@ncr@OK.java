static int ncr(int n, int c, long m) {
    long a = 1l;
    for (int x = n - c + 1; x <= n; x++) a = ((a * x) % m);
    long b = 1l;
    for (int x = 2; x <= c; x++) b = ((b * x) % m);
    long v = (div((int) b, m - 2, m) % m);
    return (int) ((a * v) % m);
}