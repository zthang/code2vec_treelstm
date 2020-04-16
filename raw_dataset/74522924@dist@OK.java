public static int dist(int a, int b) {
    // System.out.println("lca: " + lca(a,b));
    return depth[a] + depth[b] - 2 * depth[lca(a, b)];
}