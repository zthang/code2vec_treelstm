static void union(int a, int b) {
    int x = find(a);
    int y = find(b);
    if (x != y)
        dsu[x] = dsu[y];
}