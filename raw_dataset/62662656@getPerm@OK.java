private static int[] getPerm(Node[] G, int n) {
    int l = G.length;
    boolean[] visited = new boolean[l];
    int[] ret = new int[l];
    int i = 1;
    while (i < l) {
        visited[n] = true;
        ret[i++] = n;
        int tn = n;
        for (int v : G[tn].edges) if (!visited[v])
            n = v;
    }
    return ret;
}