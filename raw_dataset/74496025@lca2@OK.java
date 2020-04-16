public static int lca2(int a, int b, int[][] spar, int[] depth) {
    if (depth[a] < depth[b]) {
        b = ancestor(b, depth[b] - depth[a], spar);
    } else if (depth[a] > depth[b]) {
        a = ancestor(a, depth[a] - depth[b], spar);
    }
    if (a == b)
        return a;
    int sa = a, sb = b;
    for (int low = 0, high = depth[a], t = Integer.highestOneBit(high), k = Integer.numberOfTrailingZeros(t); t > 0; t >>>= 1, k--) {
        if ((low ^ high) >= t) {
            if (spar[k][sa] != spar[k][sb]) {
                low |= t;
                sa = spar[k][sa];
                sb = spar[k][sb];
            } else {
                high = low | t - 1;
            }
        }
    }
    return spar[0][sa];
}