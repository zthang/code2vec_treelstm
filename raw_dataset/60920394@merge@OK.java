public static void merge(int u, int v) {
    int x = find(u);
    int y = find(v);
    if (x != y) {
        union[x] = y;
    }
}