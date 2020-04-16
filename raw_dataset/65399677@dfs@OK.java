static void dfs(int i, boolean[] vis, ArrayList<Integer>[] a) {
    if (vis[i] == true)
        return;
    vis[i] = true;
    l = Math.min(l, i);
    r = Math.max(r, i);
    for (int h : a[i]) {
        dfs(h, vis, a);
    }
}