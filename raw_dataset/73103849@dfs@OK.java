static void dfs(int node, int p) {
    int val = (c[node] == 1 ? 1 : -1);
    for (int ii : adj[node]) {
        if (ii == p)
            continue;
        dfs(ii, node);
        val += Math.max(0, subVal[ii]);
    }
    subVal[node] = val;
}