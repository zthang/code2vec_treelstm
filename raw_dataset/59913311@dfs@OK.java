private static void dfs(int v) {
    used[v] = true;
    for (Integer i : G[v]) {
        if (!used[i])
            dfs(i);
    }
    postOrder.add(v);
}