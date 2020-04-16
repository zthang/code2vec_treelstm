static void merge(int x1, int y1) {
    int x = root(x1);
    int y = root(y1);
    if (size[x] < size[y]) {
        int temp = x;
        x = y;
        y = temp;
    }
    ans -= countPair(size[x]);
    ans -= countPair(size[y]);
    size[x] += size[y];
    ans += countPair(size[x]);
    parent[y] = x;
}