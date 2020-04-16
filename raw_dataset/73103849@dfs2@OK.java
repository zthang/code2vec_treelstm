static void dfs2(int node, int p) {
    if (p == -1) {
        parVal[node] = 0;
    } else {
        int val = parVal[p] + subVal[p];
        if (subVal[node] >= 0)
            val -= subVal[node];
        parVal[node] = Math.max(0, val);
    }
    for (int ii : adj[node]) if (ii != p)
        dfs2(ii, node);
}