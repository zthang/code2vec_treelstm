private int dfs1(int node, boolean[] vis) {
    vis[node] = true;
    int cnt = 0;
    int max = 0;
    for (int nn : graph[node]) {
        if (!vis[nn]) {
            cnt++;
            int v = dfs1(nn, vis);
            rec[node].add(new int[] { nn, v });
            max = Math.max(v, max);
        }
    }
    return cnt + max > 0 ? cnt + max : 1;
}