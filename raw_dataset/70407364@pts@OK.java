int pts() {
    if (state == 0 && (pr1 == -1 || pr2 == -1)) {
        return 0;
    }
    boolean bf = state == -1 || pr1 == -1;
    boolean bs = state == 1 || pr2 == -1;
    if (bf && bs)
        return 0;
    if (bf) {
        return uf_rmds.ct[uf_rmds.root(pr2)];
    }
    if (bs) {
        return uf_rmds.ct[uf_rmds.root(pr1)];
    }
    return Math.min(uf_rmds.ct[uf_rmds.root(pr2)], uf_rmds.ct[uf_rmds.root(pr1)]);
}