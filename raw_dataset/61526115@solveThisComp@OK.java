private static boolean solveThisComp(int v) {
    nVert = new int[] { 0, 0, 0 };
    for (int son : vert[v]) {
        ans[son] = 1;
    }
    if (!dfs(v))
        return false;
    nVert[0] = nVert[0] - vert[v].size();
    if (!dfs2(v, vert[v].size()))
        return false;
    if (vert[v].size() == 0)
        return false;
    if (!dfs3(vert[v].peekFirst(), 1))
        return false;
    if (!dfs4(v))
        return false;
    dfsLast(v);
    return (long) nVert[0] * nVert[1] * nVert[2] != 0;
}