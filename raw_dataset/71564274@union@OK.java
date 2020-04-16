public static void union(int x, int y) {
    int p1 = find(x);
    int p2 = find(y);
    if (p1 == p2) {
        return;
    }
    if (rank[p1] < rank[p2]) {
        parent[p1] = p2;
    } else if (rank[p2] < rank[p1]) {
        parent[p2] = p1;
    } else {
        parent[p2] = p1;
        rank[p1]++;
    }
}