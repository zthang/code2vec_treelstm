public int pow(int x, long n) {
    if (n == 0) {
        return 1;
    }
    long r = pow(x, n >> 1);
    r = modular.valueOf(r * r);
    if ((n & 1) == 1) {
        r = modular.valueOf(r * x);
    }
    return (int) r;
}