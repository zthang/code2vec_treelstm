static void dfs(int n) {
    visited[n] = true;
    for (int i = 0; i < 26; i++) {
        if (!visited[i] && r[n][i] == true)
            dfs(i);
    }
}