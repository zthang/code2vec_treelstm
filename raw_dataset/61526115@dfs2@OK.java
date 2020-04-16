static boolean dfs2(int v, int p) {
    was[v] = false;
    boolean flag = true;
    if (ans[v] == 0 && vert[v].size() != p)
        return false;
    for (int son : vert[v]) {
        if (was[son])
            flag &= dfs2(son, p);
    }
    return flag;
}