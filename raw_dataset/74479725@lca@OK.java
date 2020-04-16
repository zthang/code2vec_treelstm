public int lca(int va, int vb) {
    int pta = ptrs[va], ptb = ptrs[vb];
    return verts[rmq.min(Math.min(pta, ptb), Math.max(pta, ptb))[1]];
}