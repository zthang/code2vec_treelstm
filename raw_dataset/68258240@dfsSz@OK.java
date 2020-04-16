public int dfsSz(int v) {
    for (int i : to[v]) {
        sz[v] += dfsSz(i);
    }
    return sz[v] + 1;
}