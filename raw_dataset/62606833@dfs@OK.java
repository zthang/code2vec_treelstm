private void dfs(ArrayList<Integer>[] tree, long[] currans, long[][] cost, int node, int parent, int[] currPerm, int idx) {
    currans[node] = cost[currPerm[idx % 3] - 1][node];
    permap.put(node, currPerm[idx % 3]);
    for (int i : tree[node]) {
        if (i == parent)
            continue;
        dfs(tree, currans, cost, i, node, currPerm, idx + 1);
    }
}