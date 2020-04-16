static long solve(int root) {
    if (adj[root].size() > 2)
        return -1;
    long ans = INF;
    int first = adj[root].get(0);
    int sec = adj[root].size() == 1 ? -1 : adj[root].get(1);
    for (int i = 0; i < 3; i++) for (int j = 0; j < 3; j++) for (int k = 0; k < 3; k++) {
        if (i == j || j == k || i == k)
            continue;
        long curr = col[root][i];
        curr += dfs(first, j, i, root, false);
        if (sec != -1)
            curr += dfs(sec, k, i, root, false);
        if (curr < ans) {
            ans = curr;
            dfs(first, j, i, root, true);
            dfs(sec, k, i, root, true);
            Ans[root] = i;
        }
    }
    return ans;
}