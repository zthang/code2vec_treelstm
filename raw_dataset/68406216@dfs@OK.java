static void dfs(int i, boolean[] visited, int s) {
    if (i == s)
        return;
    visited[i] = true;
    for (int j : adjlist[i]) {
        if (!visited[j])
            dfs(j, visited, s);
    }
}