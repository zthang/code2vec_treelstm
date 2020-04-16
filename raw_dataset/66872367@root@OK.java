static int root(int p) {
    while (p != fa[p]) {
        fa[p] = fa[fa[p]];
        p = fa[p];
    }
    return p;
}