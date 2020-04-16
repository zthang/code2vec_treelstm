public static void dfs(int u, int par) {
    chain.add(u);
    for (int child : tree[u]) {
        if (child == par)
            continue;
        dfs(child, u);
    }
}