public long powMOD(long x, long n) {
    if (n == 0 || n == 1)
        return n == 0 ? 1 : x;
    long res = powMOD(x, n / 2);
    return n % 2 == 0 ? mul2(res, res) : mul3(x, res, res);
}