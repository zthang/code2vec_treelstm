public static void union(int a, int b) {
    int x = find(a);
    int y = find(b);
    fa[x] = y;
}