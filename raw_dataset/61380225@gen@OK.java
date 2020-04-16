void gen(int i) {
    if (i == n) {
        ans = Math.max(ans, get());
        return;
    }
    for (a[i] = 1; a[i] <= C; ++a[i]) gen(i + 1);
}