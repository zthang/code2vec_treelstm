static void dfs(int ind) {
    vis[ind] = 1;
    for (int i : map.get(ind)) {
        if (vis[i] == 0) {
            dfs(i);
        } else if (vis[i] == 1) {
            cyc = 1;
        }
    }
    vis[ind] = 2;
}