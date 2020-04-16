public static void dfs(int v) {
    use[v] = true;
    for (int to : lis[v]) if (!use[to])
        dfs(to);
}