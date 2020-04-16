int getParent(int u) {
    if (parr[u] == u)
        return u;
    return parr[u] = getParent(parr[u]);
}