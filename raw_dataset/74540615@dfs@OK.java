static void dfs(int n, int p) {
    start[n] = cnt++;
    for (int i = 0; i < a[n].size(); i++) {
        int idx = (int) a[n].get(i);
        if (idx != p) {
            level[idx] = level[n] + 1;
            parent[idx] = n;
            dfs(idx, n);
        }
    }
    end[n] = cnt - 1;
}