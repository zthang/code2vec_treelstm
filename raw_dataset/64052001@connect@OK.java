// "union"
public void connect(int p, int q) {
    int rootP = root(p);
    int rootQ = root(q);
    if (rootP == rootQ)
        return;
    if (weight[rootP] < weight[rootQ]) {
        parent[rootP] = rootQ;
        weight[rootQ] += weight[rootP];
    } else {
        parent[rootQ] = rootP;
        weight[rootP] += weight[rootQ];
    }
    count--;
}