static long kruskal() {
    long mst = 0;
    Arrays.sort(edgeList);
    uf = new DShichikujiAndPowerGrid.UnionFind(V);
    for (DShichikujiAndPowerGrid.Edge e : edgeList) if (!uf.isSameSet(e.u, e.v)) {
        if (e.u == 0 || e.v == 0) {
            build.add(Math.max(e.u, e.v));
        } else
            connect.add(new DShichikujiAndPowerGrid.pair(e.u, e.v));
        uf.unionSet(e.u, e.v);
        mst += e.w;
    }
    return mst;
}