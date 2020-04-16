private static int getParent(int u, int[] p, int[] minV, long[] construct) {
    if (p[u] == u)
        return u;
    p[u] = getParent(p[u], p, minV, construct);
    minV[p[u]] = construct[minV[p[u]]] < construct[minV[u]] ? minV[p[u]] : minV[u];
    return p[u];
}