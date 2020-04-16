public static void dfs(int x) {
    visit[x] = 1;
    for (int y : adj[x]) {
        if (visit[y] == 0)
            dfs(y);
    }
}