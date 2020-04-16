static void dfs(int i) {
    v[i] = true;
    for (int u : arr[i]) {
        if (!v[u]) {
            dfs(u);
        }
    }
}