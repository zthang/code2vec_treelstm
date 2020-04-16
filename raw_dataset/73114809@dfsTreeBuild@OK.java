private static void dfsTreeBuild(List<Integer>[] tree, List<Integer>[] g, int curr, int parent) {
    for (int to : g[curr]) {
        if (to == parent) {
            continue;
        }
        tree[curr].add(to);
        dfsTreeBuild(tree, g, to, curr);
    }
}