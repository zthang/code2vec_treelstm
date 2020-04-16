long Kruskal() {
    long r = 0;
    for (int i = 0; i < size; i++) {
        for (Edge e : list[i]) {
            Edges.add(new LinkEdge(e.cost, i, e.to));
        }
    }
    UnionFindTree UF = new UnionFindTree(size);
    for (LinkEdge e : Edges) {
        if (e.a >= 0 && e.b >= 0) {
            if (!UF.same(e.a, e.b)) {
                r += e.L;
                UF.unite(e.a, e.b);
            }
        }
    }
    return r;
}