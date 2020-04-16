int[] fftXor(int[] arr, int n, boolean invert, boolean doMod) {
    int[] ans = Arrays.copyOf(arr, n);
    for (int b = 1; b < n; b <<= 1) for (int i = 0; i < n; i++) {
        if ((i & b) != 0)
            continue;
        int u = ans[i], v = ans[i + b];
        if (doMod) {
            ans[i] = add(u, v);
            ans[i + b] = sub(u, v);
        } else {
            ans[i] = u + v;
            ans[i + b] = u - v;
        }
    }
    if (invert)
        for (int i = 0; i < n; i++) {
            if (doMod)
                ans[i] = mult(ans[i], inv);
            else
                ans[i] /= n;
        }
    return ans;
}