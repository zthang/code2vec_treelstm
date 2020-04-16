public static void dfs(int node) {
    if (node < minNode)
        minNode = node;
    if (node > maxNode)
        maxNode = node;
    mark[node] = true;
    for (int a : v[node]) {
        if (!mark[a]) {
            dfs(a);
        }
    }
}