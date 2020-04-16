void union(int x, int y) {
    x = root(x);
    y = root(y);
    if (x != y)
        this.size--;
    if (rank[x] < rank[y]) {
        table[x] = y;
        count[y] += count[x];
    } else if (rank[x] > rank[y]) {
        table[y] = x;
        count[x] += count[y];
    } else if (x != y) {
        table[y] = x;
        count[x] += count[y];
        rank[x]++;
    }
}