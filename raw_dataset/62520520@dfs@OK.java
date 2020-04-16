private void dfs(int v, int p, int[] a, int pos) {
    int po = a[pos];
    val += (long) c[po][v];
    colors[v] = po;
    for (int i = 0; i < list[v].size(); i++) {
        int u = list[v].get(i);
        if (u == p)
            continue;
        dfs(u, v, a, (pos + 1) % 3);
    }
}