int find(int b) {
    if (a[b] < 0)
        return b;
    return a[b] = find(a[b]);
}