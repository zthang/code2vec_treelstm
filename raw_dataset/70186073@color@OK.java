void color(int v, int col, boolean flag) {
    color[v] = col;
    dfs(v, v, flag);
    int pv = find(v);
    cnt[pv][0] = cnt[v][0];
    cnt[pv][1] = cnt[v][1];
}