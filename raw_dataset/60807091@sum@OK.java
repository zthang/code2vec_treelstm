long sum(int node, int par) {
    if (sum[node] != -1)
        return sum[node];
    long cmax = 0;
    for (int[] e : adj[node]) if (e[1] != par) {
        cmax = Math.max(cmax, sum(e[1], node));
    }
    return sum[node] = w[node] + cmax;
}