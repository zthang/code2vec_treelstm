private static void dfsTreeBuild(List<Integer>[] t, Set<Integer>[] g, int cur, int parent) {
    for (int to : g[cur]) {
        if (to == parent)
            continue;
        t[cur].add(to);
        dfsTreeBuild(t, g, to, cur);
    }
}