private int dfs(int node, boolean[] vis) {
    vis[node] = true;
    int ret = 1;
    for (int[] node2 : graph[node]) {
        int nn = node2[0];
        long w = node2[1];
        if (!vis[nn]) {
            int r = dfs(nn, vis);
            ret += r;
            if (r % 2 == 1) {
                min += w;
            }
            max += Math.min(r, n - r) * w;
        }
    }
    return ret;
}