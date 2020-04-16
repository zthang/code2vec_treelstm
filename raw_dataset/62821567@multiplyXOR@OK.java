int[] multiplyXOR(int[] a, int[] b) {
    int n = Math.max(a.length, b.length);
    if ((n & (n - 1)) != 0)
        n = Integer.highestOneBit(n) * 2;
    a = fftXOR(a, n, false);
    b = fftXOR(b, n, false);
    for (int i = 0; i < a.length; i++) a[i] *= b[i];
    a = fftXOR(a, n, true);
    return a;
}