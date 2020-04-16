public static boolean isAncestor(int v, int u) {
    return (time_in[v] <= time_in[u] && time_out[u] <= time_out[v]);
}