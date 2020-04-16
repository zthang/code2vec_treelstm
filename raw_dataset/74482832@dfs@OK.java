static void dfs(int x, int dep) {
    depth[x] = dep;
    for (Integer i : edge.get(x)) {
        if (depth[i] == -1) {
            parent[0][i] = x;
            dfs(i, dep + 1);
        }
    }
}