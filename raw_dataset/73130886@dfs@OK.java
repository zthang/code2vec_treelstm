public static void dfs(int[] a, int index, int par) {
    vis[index] = true;
    if (a[index] == 1) {
        diff[index] = 1;
    } else
        diff[index] = -1;
    for (int i = 0; i < graph[index].size(); i++) {
        int v = graph[index].get(i);
        if (!vis[v]) {
            dfs(a, v, index);
            diff[index] += Math.max(0, diff[v]);
        }
    }
}