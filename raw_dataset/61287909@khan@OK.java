static int[] khan(int V, int[][] G) {
    int[] deg = new int[V];
    for (int[] tos : G) {
        for (int to : tos) {
            deg[to]++;
        }
    }
    int[] q = new int[V];
    int a = 0, b = 0;
    for (int v = 0; v < V; v++) {
        if (deg[v] == 0)
            q[b++] = v;
    }
    int[] ret = new int[V];
    int idx = 0;
    while (a != b) {
        int v = q[a++];
        ret[idx++] = v;
        for (int to : G[v]) {
            deg[to]--;
            if (deg[to] == 0) {
                q[b++] = to;
            }
        }
    }
    for (int v = 0; v < V; v++) {
        if (deg[v] != 0)
            return null;
    }
    return ret;
}