void union(int x, int y) {
    int xRoot = find(x), yRoot = find(y);
    if (xRoot == yRoot) {
        return;
    }
    if (size[xRoot] < size[yRoot]) {
        parent[xRoot] = yRoot;
        size[yRoot] += size[xRoot];
    } else if (size[yRoot] < size[xRoot]) {
        parent[yRoot] = xRoot;
        size[xRoot] += size[yRoot];
    } else {
        parent[yRoot] = xRoot;
        size[xRoot] += size[yRoot];
    }
}