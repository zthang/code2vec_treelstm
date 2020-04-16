private void generate(int l, int r, int[] a) {
    if (l == r) {
        val = 0;
        dfs(st, st, a, 0);
        if (val < min) {
            min = val;
            for (int i = 0; i < n; i++) ans[i] = colors[i];
        }
        return;
    }
    for (int i = l; i <= r; i++) {
        int tmp = a[l];
        a[l] = a[i];
        a[i] = tmp;
        generate(l + 1, r, a);
        tmp = a[l];
        a[l] = a[i];
        a[i] = tmp;
    }
}