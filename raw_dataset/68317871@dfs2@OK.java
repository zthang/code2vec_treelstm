void dfs2(MultiWayIntegerStack tree, int u, int p, int up) {
    a[u] = up | Integer.lowestOneBit(i[u]);
    for (IntegerIterator iterator = tree.iterator(u); iterator.hasNext(); ) {
        int v = iterator.next();
        if (v == p)
            continue;
        dfs2(tree, v, u, a[u]);
    }
}