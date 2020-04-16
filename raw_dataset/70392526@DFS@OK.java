static int DFS(int s, int par) {
    if (s != 1 && adj[s].size() == 1) {
        dp[s][1] = 1;
        dp[s][0] = 1;
    } else {
        for (int e : adj[s]) {
            if (e != par) {
                child[s].add(DFS(e, s));
            }
        }
        Collections.sort(child[s]);
        if (child[s].size() == 1) {
            dp[s][1] = child[s].get(0) + 1;
            dp[s][0] = dp[s][1];
        } else {
            int size = child[s].size() - 2;
            dp[s][0] = child[s].get(size + 1) + child[s].get(size) + size + 1;
            dp[s][1] = child[s].get(size + 1) + size + 2;
        }
    }
    return dp[s][1];
}