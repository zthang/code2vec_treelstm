public boolean union(int x, int y) {
    x = find(x);
    y = find(y);
    if (x == y) {
        return false;
    } else if (rank[x] < rank[y]) {
        nodes[y] += nodes[x];
        nodes[x] = y;
    } else if (rank[x] == rank[y]) {
        rank[x]++;
        nodes[x] += nodes[y];
        nodes[y] = x;
    } else {
        nodes[x] += nodes[y];
        nodes[y] = x;
    }
    groups--;
    return true;
}