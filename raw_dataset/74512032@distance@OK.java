static int distance(int a, int b) {
    return depth[a] + depth[b] - 2 * depth[leastCommonAncestor(a, b)];
}