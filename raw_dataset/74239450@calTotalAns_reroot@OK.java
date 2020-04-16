static void calTotalAns_reroot(int u, int p) {
    // u: I am the new root --- // p : I am the old parent of that r=node and now I am a child so complete the partial answer by considering me
    if (p != -1) {
        ans[u] = partialAns[u] + Math.max(0, ans[p] - Math.max(0, partialAns[u]));
    }
    for (int v : adj[u]) {
        if (// if it is child
        v != p) {
            calTotalAns_reroot(v, u);
        }
    }
}