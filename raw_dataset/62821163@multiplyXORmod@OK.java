int[] multiplyXORmod(int[] a, int[] b) {
    int n = Math.max(a.length, b.length);
    if ((n & (n - 1)) != 0)
        n = Integer.highestOneBit(n) * 2;
    a = fftXORmod(a, n, false);
    b = fftXORmod(b, n, false);
    for (int i = 0; i < a.length; i++) a[i] = mult(a[i], b[i]);
    a = fftXORmod(a, n, true);
    return a;
}