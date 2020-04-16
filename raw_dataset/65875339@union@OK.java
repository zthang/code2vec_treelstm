void union(int x, int y) {
    x = find(x);
    y = find(y);
    if (x == y)
        return;
    max[x] = Math.max(max[x], max[y]);
    parent[y] = x;
}