public boolean unite(int a, int b) {
    int pa = get(a);
    int pb = get(b);
    if (sz[pa] == 1) {
        p[pa] = pb;
        sz[pb] += sz[pa];
        return true;
    }
    if (sz[pb] == 1) {
        p[pb] = pa;
        sz[pa] += sz[pb];
        return true;
    }
    return false;
}