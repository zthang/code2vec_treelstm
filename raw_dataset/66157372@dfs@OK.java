void dfs(int u) {
    idx[u] = k;
    if (u > a[k].y) {
        a[k].y = u;
    }
    use[u] = true;
    int p = tab[u];
    while (p != -1) {
        int v = node[p].v;
        if (!use[v]) {
            dfs(v);
        }
        p = node[p].next;
    }
}