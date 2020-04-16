public static void union(int a, int b) {
    int p1 = findSet(a);
    int p2 = findSet(b);
    if (p1 == p2) {
        count++;
        return;
    }
    if (size[p1] > size[p2]) {
        parent[p2] = p1;
        size[p1] += size[p2];
    } else if (size[p1] < size[p2]) {
        parent[p1] = p2;
        size[p2] += size[p1];
    } else {
        parent[p2] = p1;
        size[p1] += size[p2];
    }
}