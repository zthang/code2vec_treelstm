public void union(int x, int y) {
    int ra = root(x);
    int rb = root(y);
    if (ra == rb)
        return;
    if (size[ra] < size[rb]) {
        root[ra] = root[rb];
        size[rb] += size[ra];
    } else {
        root[rb] = root[ra];
        size[ra] += size[rb];
    }
    return;
}