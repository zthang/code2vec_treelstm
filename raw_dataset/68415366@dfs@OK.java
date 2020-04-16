static void dfs(int i) {
    visited[i] = true;
    farthest = Math.max(i, farthest);
    for (int j : adjlist[i]) {
        if (!visited[j])
            dfs(j);
    }
}