static void dfs(int s) {
    mx = Math.max(s, mx);
    vis[s] = true;
    for (int i : ar[s]) if (!vis[i])
        dfs(i);
}