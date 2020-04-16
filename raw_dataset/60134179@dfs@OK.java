boolean dfs(boolean[] vis, boolean[] st, int cur, ArrayList<Integer>[] a) {
    st[cur] = true;
    for (int i : a[cur]) {
        if (!vis[i]) {
            vis[i] = true;
            if (dfs(vis, st, i, a))
                return true;
        }
        if (st[i])
            return true;
    }
    st[cur] = false;
    return false;
}