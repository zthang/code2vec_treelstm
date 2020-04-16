static void dfs(int cur, int p) {
    if (vis[cur]) {
        System.out.println("NO");
        System.exit(0);
    }
    vis[cur] = true;
    for (int ee : graph[cur]) {
        if (ee == p)
            continue;
        dfs(ee, cur);
    }
}