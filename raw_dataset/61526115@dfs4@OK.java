private static boolean dfs4(int v) {
    was[v] = false;
    if (nVert[0] + nVert[1] + nVert[2] - nVert[ans[v]] != vert[v].size())
        return false;
    boolean flag = true;
    for (int son : vert[v]) {
        if (was[son])
            flag &= dfs4(son);
    }
    return flag;
}