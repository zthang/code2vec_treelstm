static void dfs1(int nd, int pr) {
    dp1[nd] = (arr[nd] == 1 ? 1 : -1);
    for (Object ch : adj[nd]) {
        if ((int) ch != pr) {
            dfs1((int) ch, nd);
            dp1[nd] += Math.max(0, dp1[(int) ch]);
        }
    }
}