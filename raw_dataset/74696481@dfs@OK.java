public static void dfs(int v, int p) {
    for (int i : graph[v]) if (i != p)
        add(i);
    for (int i : graph[v]) if (i != p)
        dfs(i, v);
    for (int i : graph[v]) if (i != p)
        remove(i);
}