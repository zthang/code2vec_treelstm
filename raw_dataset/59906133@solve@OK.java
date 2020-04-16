void solve() {
    int n = ni(), m = ni();
    Node[] p = new Node[n - 1];
    for (int i = 0; i < n - 1; i++) p[i] = new Node(ni(), ni(), ni());
    Arrays.sort(p);
    ans = new long[200001];
    F = new int[n + 1];
    sz = new int[n + 1];
    for (int i = 1; i <= n; i++) {
        F[i] = i;
        sz[i] = 1;
    }
    for (int i = 0; i < n - 1; i++) {
        union(p[i].u, p[i].v, p[i].w);
    }
    for (int i = 1; i <= 200000; i++) ans[i] += ans[i - 1];
    while (m-- > 0) {
        int w = ni();
        pw.print(ans[w] + " ");
    }
    pw.println("");
}