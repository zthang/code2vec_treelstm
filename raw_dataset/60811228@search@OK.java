private static long[] search(int u, List<List<Integer>> links, boolean[] visited, int[] w, int parent) {
    visited[u] = true;
    long base = 0;
    long tree = 0;
    boolean isTree = true;
    for (int v : links.get(u)) {
        if (!visited[v]) {
            long[] child = search(v, links, visited, w, u);
            base += child[0];
            tree = Math.max(tree, child[1]);
            if (child[2] > 0)
                isTree = false;
        } else if (v != parent) {
            isTree = false;
        }
    }
    if (!isTree)
        base += w[u];
    else
        tree += w[u];
    return new long[] { base, tree, isTree ? 0 : 1 };
}