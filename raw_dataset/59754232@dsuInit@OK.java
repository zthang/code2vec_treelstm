void dsuInit(int n) {
    parent = new int[n];
    sz = new long[n];
    for (int i = 0; i < n; i++) {
        parent[i] = i;
        sz[i] = 1;
    }
}