int lca2(int a, int b, int[][] sparse, int[] depth) {
    if (depth[a] < depth[b]) {
        b = ancestor(b, depth[b] - depth[a], sparse);
    } else if (depth[a] > depth[b]) {
        a = ancestor(a, depth[a] - depth[b], sparse);
    }
    if (a == b) {
        return a;
    }
    int sa = a, sb = b;
    for (int low = 0, high = depth[a], t = Integer.highestOneBit(high), k = Integer.numberOfTrailingZeros(t); t > 0; t >>>= 1, k--) {
        if ((low ^ high) >= t) {
            if (sparse[k][sa] != sparse[k][sb]) {
                low |= t;
                sa = sparse[k][sa];
                sb = sparse[k][sb];
            } else {
                high = low | t - 1;
            }
        }
    }
    return sparse[0][sa];
}