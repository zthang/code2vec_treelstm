static int cnt(int a, int b) {
    Arrays.fill(visited, false);
    visited[b] = true;
    dfs(a);
    int ans = 0;
    for (int i = 0; i < visited.length; i++) if (!visited[i])
        ans++;
    return ans;
}