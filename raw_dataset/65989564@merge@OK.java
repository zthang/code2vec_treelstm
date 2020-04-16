public void merge(int x, int y, int[] parent, int[] size) {
    x = getParent(x, parent);
    y = getParent(y, parent);
    if (x == y) {
        return;
    }
    if (size[x] < size[y]) {
        parent[x] = y;
        size[y] += size[x];
    } else {
        parent[y] = x;
        size[x] += size[y];
    }
}