static void calPartialAns(int u, int p) {
    // u:I will consider the best out come from the subtree that I am root of (i.e. from all my children only not considering the parent) so I look below
    partialAns[u] = color[u] == 1 ? 1 : -1;
    for (int v : adj[u]) {
        if (// if it is child
        v != p) {
            calPartialAns(v, u);
            // System.out.println(v+" : "+partialAns[v]);
            partialAns[u] += Math.max(0, partialAns[v]);
        }
    }
}