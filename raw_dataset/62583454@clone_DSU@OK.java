DSU clone_DSU() {
    DSU t = new DSU(par.length);
    t.connectedComponent = connectedComponent;
    for (int i = 0; i < par.length; i++) {
        t.par[i] = par[i];
        t.size[i] = size[i];
    }
    return t;
}