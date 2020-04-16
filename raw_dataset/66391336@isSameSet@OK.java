public boolean isSameSet(int u, int v) {
    return findParent(u) == findParent(v);
}