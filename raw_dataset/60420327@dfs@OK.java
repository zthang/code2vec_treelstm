public static boolean dfs(ArrayList<Pair>[] grph, int u, int[] ans, boolean[] vis, boolean[] inpath) {
    vis[u] = true;
    inpath[u] = true;
    boolean iscycle = false;
    for (int i = 0; i < grph[u].size(); i++) {
        Pair p = grph[u].get(i);
        int v = p.first;
        if (inpath[v]) {
            iscycle = true;
            ans[p.second] = 2;
        } else if (vis[v]) {
            ans[p.second] = 1;
        } else {
            ans[p.second] = 1;
            iscycle |= dfs(grph, v, ans, vis, inpath);
        }
    }
    inpath[u] = false;
    return iscycle;
}