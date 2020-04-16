public static boolean isAncestor(int u, int v) {
    return (timeIn[u] <= timeIn[v] && timeOut[v] <= timeOut[u]);
}