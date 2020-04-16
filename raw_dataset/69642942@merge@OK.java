void merge(int x, int y) {
    x = root(x);
    y = root(y);
    if (x == y)
        return;
    else {
        w[x] += w[y];
        root[y] = x;
        for (int neighbor : adjTree[y]) adjTree[x].add(root(neighbor));
    }
}