public static void union(int i, int j) {
    int x = findRep(i), y = findRep(j);
    if (x == y) {
        // already in same group
        return;
    }
    if (x > y) {
        parent[y] = x;
    } else if (y > x) {
        parent[x] = y;
    } else {
        parent[x] = y;
    }
}