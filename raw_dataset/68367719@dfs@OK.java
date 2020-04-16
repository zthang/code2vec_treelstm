void dfs(int u) {
    if (g[u].size() == 0) {
        al[u].add(u);
        if (a[u] != 0)
            kk = 1;
        return;
    }
    for (int v : g[u]) {
        dfs(v);
        al[u].addAll(al[v]);
    }
    if (a[u] > al[u].size()) {
        kk = 1;
        return;
    }
    // System.out.println(u+" "+al[u]);
    al[u].add(0);
    for (int i = al[u].size() - 1; i > a[u]; i--) {
        al[u].set(i, al[u].get(i - 1));
    }
    al[u].set(a[u], u);
// System.out.println(u+" "+al[u]);
}