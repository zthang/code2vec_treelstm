void solve() {
    int n = in.nextInt();
    int k = in.nextInt();
    p = new int[n];
    sz = new int[n];
    for (int i = 0; i < n; i++) {
        p[i] = i;
        sz[i] = 1;
    }
    for (int i = 0; i < k; i++) {
        int x = in.nextInt() - 1;
        int y = in.nextInt() - 1;
        unite(x, y);
    }
    int totalOk = 0;
    for (int i = 0; i < n; i++) {
        if (get(i) == i) {
            totalOk += sz[i] - 1;
        }
    }
    out.println(k - totalOk);
}