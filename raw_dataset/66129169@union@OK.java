private static void union(int[] a, int[] r, int i, int j) {
    int root1 = find(a, i);
    int root2 = find(a, j);
    if (root2 == root1)
        return;
    if (r[root1] >= r[root2]) {
        a[root2] = root1;
        r[root2] += r[root1];
    } else {
        a[root1] = root2;
        r[root1] += r[root2];
    }
}