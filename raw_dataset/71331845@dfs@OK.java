public void dfs(int cur) {
    visited[cur] = true;
    for (Integer v : con[cur]) {
        if (!visited[v]) {
            dfs(v);
        }
    }
}