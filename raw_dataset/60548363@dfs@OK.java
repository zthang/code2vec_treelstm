public int dfs(int v) {
    used[v] = true;
    int ans = 0;
    for (int e : to[v]) {
        if (!used[e]) {
            ans += dfs(e);
        }
    }
    return ans + 1;
}