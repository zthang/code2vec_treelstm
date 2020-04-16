public void dfs(int cur, int p, int l) {
    par[cur][0] = p;
    lvl[cur] = l;
    for (int i : a[cur]) if (i != p)
        dfs(i, cur, l + 1);
}