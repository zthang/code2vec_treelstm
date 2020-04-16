static int dfs2(ArrayList<Integer>[] adj, int u, int[] subcnt, int[] c, int start, boolean[] taken, int[] ans) {
    int num = start;
    for (int s = 0; s < c[u] || taken[num]; ++num) {
        if (!taken[num])
            s++;
    }
    int ret = num;
    ans[u] = num;
    taken[num] = true;
    num = start;
    for (int v : adj[u]) {
        int m = dfs2(adj, v, subcnt, c, num, taken, ans);
        ret = Math.max(ret, m);
        num = m + 1;
    }
    return ret;
}