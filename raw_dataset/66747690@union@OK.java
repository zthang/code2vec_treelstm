public void union(int a, int b) {
    int x = find(a);
    int y = find(b);
    if (x == y)
        return;
    arr[y] = x;
    sz[x] += sz[y];
}