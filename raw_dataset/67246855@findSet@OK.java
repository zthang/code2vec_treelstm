int findSet(int v) {
    if (v == p[v])
        return v;
    max[v] = Math.max(max[v], max[p[v]]);
    p[v] = findSet(p[v]);
    max[v] = Math.max(max[v], max[p[v]]);
    return p[v];
}