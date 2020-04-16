void dfs1(MultiWayIntegerStack tree, int u, int p) {
    parent[u] = p;
    i[u] = preOrder[u] = time++;
    for (IntegerIterator iterator = tree.iterator(u); iterator.hasNext(); ) {
        int v = iterator.next();
        if (v == p)
            continue;
        dfs1(tree, v, u);
        if (Integer.lowestOneBit(i[u]) < Integer.lowestOneBit(i[v])) {
            i[u] = i[v];
        }
    }
    head[i[u]] = u;
}