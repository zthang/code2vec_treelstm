int find(int x) {
    if (a[x] < 0)
        return x;
    return a[x] = find(a[x]);
}