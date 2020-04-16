public static List<Graphs.LEdge> findMSTUsingKruskalLong(int n, List<Graphs.LEdge> edges) {
    edges.sort(Comparator.comparingLong(i -> i.cost));
    UnionFind uf = new UnionFind(n);
    List<Graphs.LEdge> mst = new ArrayList<>();
    for (Graphs.LEdge e : edges) {
        if (uf.rep(e.i) != uf.rep(e.j)) {
            mst.add(e);
            uf.union(e.i, e.j);
        }
    }
    return mst;
}