static void dfs(int n, int x) {
    visited[n] = true;
    for (int i = 0; i < a[n].size(); i++) {
        int idx = (int) a[n].get(i);
        if (!visited[idx] && idx != x) {
            dfs(idx, x);
        }
    }
}