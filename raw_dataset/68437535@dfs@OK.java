void dfs(int u) {
    visit[u] = true;
    for (int i = 0; i < 26; i++) {
        if (a[i] && !visit[i] && c[i][u]) {
            dfs(i);
        }
    }
}