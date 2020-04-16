int dfs(int node, boolean[] flag, boolean[] vis) {
    vis[node] = true;
    int r = 1;
    for (int nn : graph[node]) {
        if (nn == b)
            flag[0] = true;
        if (nn == a || vis[nn] || nn == b)
            continue;
        r += dfs(nn, flag, vis);
    }
    return r;
}