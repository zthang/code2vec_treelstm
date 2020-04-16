long dfs2(int at, int p) {
    v[at] = true;
    if (!conn[at]) {
        for (int to : G[at]) {
            if (to == p)
                continue;
            sum[to] = dfs2(to, at);
            sum[at] = Math.max(sum[at], sum[to]);
        }
        return sum[at] += w[at];
    } else {
        for (int to : G[at]) {
            if (to == p)
                continue;
            if (v[to])
                continue;
            dfs2(to, at);
        }
    }
    return 0;
}