static long dfs(int start, int par) {
    long max = 0, smax = 0;
    for (Pair p : graph[start]) {
        if (p.u == par)
            continue;
        long u = dfs(p.u, start);
        if (u >= max) {
            smax = max;
            max = u;
        } else if (smax < u) {
            smax = u;
        }
    }
    if (smax != 0) {
        ans = Math.max(graph[start].size() - 1 + max + smax, ans);
    } else if (max != 0) {
        ans = Math.max(graph[start].size() + max, ans);
    }
    // debug(start,ans,max,smax);
    if (max != 0)
        max += graph[start].size() - 1;
    else
        max = 1;
    return max;
}