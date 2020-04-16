long union(int x, int y, long ans) {
    int xRoot = find(x), yRoot = find(y);
    if (xRoot == yRoot) {
        return ans;
    }
    long hp = ans;
    ans -= size[xRoot] * (size[xRoot] - 1) / 2;
    ans -= size[yRoot] * (size[yRoot] - 1) / 2;
    if (size[xRoot] < size[yRoot]) {
        parent[xRoot] = yRoot;
        size[yRoot] += size[xRoot];
        ans += size[yRoot] * (size[yRoot] - 1) / 2;
    } else if (size[yRoot] < size[xRoot]) {
        parent[yRoot] = xRoot;
        size[xRoot] += size[yRoot];
        ans += size[xRoot] * (size[xRoot] - 1) / 2;
    } else {
        parent[yRoot] = xRoot;
        size[xRoot] += size[yRoot];
        ans += size[xRoot] * (size[xRoot] - 1) / 2;
    }
    return ans;
}