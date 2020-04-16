// merge as weight(y) = weight(x) + w
public void merge(int x, int y, int w) {
    w += calcWeight(x);
    w -= calcWeight(y);
    int xr = root(x);
    int yr = root(y);
    if (xr == yr) {
        return;
    }
    if (rank[xr] < rank[yr]) {
        par[xr] = yr;
        weight[xr] = -w;
    } else {
        par[yr] = xr;
        weight[yr] = w;
        if (rank[xr] == rank[yr]) {
            rank[xr]++;
        }
    }
}