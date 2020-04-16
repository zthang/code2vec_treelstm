// only connect p and q if they are disjointed.
public void connect(int p, int q) {
    int rootP = root(p);
    int rootQ = root(q);
    if (rank[rootP] >= rank[rootQ]) {
        parent[rootQ] = rootP;
        rank[rootP] += rank[rootQ];
    } else if (rank[rootQ] > rank[rootP]) {
        parent[rootP] = rootQ;
        rank[rootQ] += rank[rootP];
    }
    count--;
}