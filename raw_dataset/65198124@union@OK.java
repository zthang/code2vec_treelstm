void union(int u, int v) {
    int r1 = root(u);
    int r2 = root(v);
    if (r1 != r2) {
        if (size[r1] < size[r2]) {
            arr[r1] = arr[r2];
            size[r2] += size[r1];
        } else {
            arr[r2] = arr[r1];
            size[r1] += size[r2];
        }
    }
}