public static int dfs(int s) {
    int ans = 1;
    visited[s] = true;
    for (int k : list[s]) {
        if (!visited[k]) {
            ans += dfs(k);
        }
    }
    return ans;
}