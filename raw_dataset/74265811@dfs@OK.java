static void dfs(int node, int par, int dist) {
    if (dist >= maxcount) {
        maxcount = dist;
        x = node;
    }
    List<Integer> l = adj[node];
    for (Integer i : l) {
        if (i != par)
            dfs(i, node, dist + 1);
    }
}