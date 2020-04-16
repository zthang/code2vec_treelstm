public static void union(int[] parent, int[] size, int[] mx, int x, int y) {
    int xRoot = find(parent, x);
    int yRoot = find(parent, y);
    if (xRoot != yRoot) {
        if (size[xRoot] < size[yRoot]) {
            int temp = xRoot;
            xRoot = yRoot;
            yRoot = temp;
        }
        parent[yRoot] = xRoot;
        size[xRoot] = size[xRoot] + size[yRoot];
        mx[xRoot] = Math.max(mx[xRoot], mx[yRoot]);
    }
}