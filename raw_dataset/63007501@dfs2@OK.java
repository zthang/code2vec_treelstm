void dfs2(int x) {
    ans.add(x);
    if (used[x])
        return;
    used[x] = true;
    for (int to : es[x]) {
        dfs2(to);
    }
}