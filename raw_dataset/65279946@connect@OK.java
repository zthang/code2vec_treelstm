// "union"
public void connect(int p, int q) {
    int rootP = root(p);
    int rootQ = root(q);
    if (rootP == rootQ)
        return;
    if (weight[rootP] < weight[rootQ]) {
        parent[rootP] = rootQ;
        weight[rootQ] += weight[rootP];
        minmax[rootQ][0] = Math.min(minmax[rootQ][0], minmax[rootP][0]);
        minmax[rootQ][1] = Math.max(minmax[rootQ][1], minmax[rootP][1]);
    } else {
        parent[rootQ] = rootP;
        weight[rootP] += weight[rootQ];
        minmax[rootP][0] = Math.min(minmax[rootQ][0], minmax[rootP][0]);
        minmax[rootP][1] = Math.max(minmax[rootQ][1], minmax[rootP][1]);
    }
    count--;
}