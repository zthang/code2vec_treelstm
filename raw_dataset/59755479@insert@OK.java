public void insert(int x, int y) {
    x = parent(x);
    y = parent(y);
    if (x == y)
        return;
    if (depth[x] < depth[y]) {
        int temp = x;
        x = y;
        y = temp;
    }
    ifEmpty(depth[x]);
    ifEmpty(depth[y]);
    p[y] = p[x];
    depth[x] += depth[y];
    map.put(depth[x], map.getOrDefault(depth[x], 0) + 1);
}