public boolean unite(int u, int v) {
    int par1 = getPar(u), par2 = getPar(v);
    if (par1 == par2)
        return false;
    con--;
    if (sz[par1] > sz[par2]) {
        int tem = par1;
        par1 = par2;
        par2 = tem;
    }
    sz[par2] += sz[par1];
    sz[par1] = 0;
    par[par1] = par[par2];
    return true;
}