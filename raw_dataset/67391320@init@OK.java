static void init(int n) {
    p = new int[n + 1];
    size = new int[n + 1];
    for (int i = 1; i <= n; i++) {
        p[i] = i;
    }
}