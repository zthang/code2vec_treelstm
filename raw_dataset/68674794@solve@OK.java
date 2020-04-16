void solve() {
    int n = ni();
    g = new ArrayList[n + 1];
    c = new int[n + 1];
    int root = -1;
    for (int i = 1; i <= n; i++) g[i] = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
        int p = ni();
        c[i] = ni();
        if (p == 0) {
            root = i;
            continue;
        }
        g[p].add(i);
        g[i].add(p);
    }
    check = true;
    dfs(root, -1);
    if (!check) {
        pw.println("NO");
        return;
    }
    list = new ArrayList<>();
    for (int i = 1; i <= n; i++) list.add(i);
    ans = new int[n + 1];
    dfs2(root, -1);
    pw.println("YES");
    for (int i = 1; i <= n; i++) pw.print(ans[i] + " ");
    pw.println("");
}