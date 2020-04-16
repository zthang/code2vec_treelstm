int[] fftXORmod(int[] a, int n, boolean invert) {
    int[] ans = Arrays.copyOf(a, n);
    for (int b = 1; b < n; b <<= 1) {
        for (int i = 0; i < n; i++) {
            if ((i & b) != 0)
                continue;
            int u = ans[i], v = ans[i + b];
            ans[i] = add(u, v);
            ans[i + b] = sub(u, v);
        }
    }
    long invn = inv(n, mod);
    if (invert)
        for (int i = 0; i < n; i++) ans[i] = mult(ans[i], invn);
    return ans;
}