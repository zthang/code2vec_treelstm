static int dfs(boolean[] visit, Seg u) {
    if (visit[u.idx])
        return 0;
    visit[u.idx] = true;
    int ret = 1;
    for (Seg v : u.adj) {
        if (!visit[v.idx]) {
            ret += dfs(visit, v);
        }
    }
    return ret;
}