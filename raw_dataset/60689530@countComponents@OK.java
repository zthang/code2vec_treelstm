static int countComponents(int n, int[][] edges) {
    int count = n;
    int[] root = new int[n + 1];
    // initialize each node is an island
    for (int i = 1; i <= n; i++) {
        root[i] = i;
    }
    for (int i = 0; i < edges.length; i++) {
        int x = edges[i][0];
        int y = edges[i][1];
        int xRoot = getRoot(root, x);
        int yRoot = getRoot(root, y);
        if (xRoot != yRoot) {
            count--;
            root[xRoot] = yRoot;
        }
    }
    return count;
}