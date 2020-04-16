static void dfs2(int start, int par, int h) {
    order[h] = start;
    for (Pair p : graph[start]) {
        if (p.u == par)
            continue;
        dfs2(p.u, start, h + 1);
    }
}