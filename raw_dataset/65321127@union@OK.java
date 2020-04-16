public void union(int x, int y) {
    x = find(x);
    y = find(y);
    if (x != y) {
        if (y > x) {
            parent[y] = x;
            size[x] += size[y];
        } else {
            parent[x] = y;
            size[y] += size[x];
        }
    }
}