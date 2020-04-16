static boolean dfs(int v) {
    if (c[v] >= clist.size() || c[v] >= subcount[v])
        return false;
    a[v] = clist.get(c[v]);
    clist.remove(c[v]);
    boolean ret = true;
    for (int i : list.get(v)) ret = ret && dfs(i);
    return ret;
}