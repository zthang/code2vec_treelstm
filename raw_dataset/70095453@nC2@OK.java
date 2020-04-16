static long nC2(long n) {
    n *= (n - 1l);
    n /= 2l;
    return n;
}