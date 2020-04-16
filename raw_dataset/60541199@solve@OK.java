static void solve() throws Exception {
    int n = scanInt(), k = scanInt();
    edges = new IntList[n];
    for (int i = 0; i < n; i++) {
        edges[i] = new IntList();
    }
    for (int i = 0; i < k; i++) {
        int a = scanInt() - 1, b = scanInt() - 1;
        edges[a].push(b);
        edges[b].push(a);
    }
    int ans = k - n;
    seen = new boolean[n];
    for (int i = 0; i < n; i++) {
        if (!seen[i]) {
            ++ans;
            dfs(i);
        }
    }
    out.print(ans);
}