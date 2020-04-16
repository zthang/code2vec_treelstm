public static void union(int i, int j) {
    int p1 = find(i);
    int p2 = find(j);
    if (p1 == p2)
        return;
    parent[p1] = p2;
    size[p2] += size[p1];
    size[p1] = 0;
}