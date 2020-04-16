public static int find(int u) {
    if (union[u] == u) {
        return u;
    } else {
        return union[u] = find(union[u]);
    }
}