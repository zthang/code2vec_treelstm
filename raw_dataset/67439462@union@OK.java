public static void union(int x, int y) {
    x = find(x);
    y = find(y);
    parent[y] = x;
}