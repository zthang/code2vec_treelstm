public static void union(int x, int y) {
    if (x == y)
        return;
    while (prr[x] != x) {
        x = prr[x];
    }
    while (prr[y] != y) y = prr[y];
    prr[y] = x;
}