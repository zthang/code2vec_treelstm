BitSet getNeighborhood(int v) {
    BitSet nbrs = new BitSet(maxColor);
    for (int e : edges[v]) {
        if (e != a && e != b)
            nbrs.set(colors[e] - 1);
    }
    return nbrs;
}