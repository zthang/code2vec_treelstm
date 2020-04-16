public static void DFS(int pos, int src, int d) {
    parent[pos] = src;
    depth[pos] = d;
    ins[pos] = t;
    t++;
    for (int node : tree.get(pos)) {
        if (node != src) {
            DFS(node, pos, d + 1);
        }
    }
    outs[pos] = t;
}