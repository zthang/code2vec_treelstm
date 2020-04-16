public static Set<Integer>[] build(InputReader in, int numV, int numE, boolean zeroIndex) {
    // offset for neighbors array
    int offset = zeroIndex ? 0 : 1;
    Set<Integer>[] g = new Set[numV + offset];
    for (int i = offset; i < numV + offset; ++i) g[i] = new HashSet<>();
    for (int i = 0; i < numE; ++i) {
        // offset for vertices
        offset = zeroIndex ? 1 : 0;
        int u = in.nextInt() - offset, v = in.nextInt() - offset;
        g[u].add(v);
        g[v].add(u);
    }
    return g;
}