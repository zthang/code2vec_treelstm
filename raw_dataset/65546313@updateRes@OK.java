private static long updateRes(Edge edge, UnionFind uf) {
    int g1 = uf.sizeOfSet(edge.from), g2 = uf.sizeOfSet(edge.to);
    long result = compute(g1 + g2) - compute(g1) - compute(g2);
    return result;
}