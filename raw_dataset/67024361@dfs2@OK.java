static int dfs2(int u, int p) {
    int cnt = 1;
    for (wt i : graph[u]) {
        if (i.u == p)
            continue;
        int c = dfs2(i.u, u);
        cnt += c;
        ans_min += (c % 2 == 1 ? 1L * i.w : 0);
        ans_max += (1L * i.w * Math.min(c, 2 * k - c));
    }
    return cnt;
}