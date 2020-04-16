static void union(int x, int y) {
    x = find(x);
    y = find(y);
    if (x == y)
        return;
    if (size[x] < size[y])
        swap(x, y);
    par[y] = x;
    size[x] += size[y];
}