long power(int a, int k) {
    if (k == 0)
        return 1;
    long p = power(a, k / 2);
    p = p * p % MD;
    if (k % 2 == 1)
        p = p * a % MD;
    return p;
}