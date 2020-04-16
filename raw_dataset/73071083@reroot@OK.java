static void reroot(int u, int p) {
    if (p != -1) {
        // System.out.println(u+" "+p+" "+ans[p]+" "+res[u]);
        ans[u] = res[u] + Math.max(0, ans[p] - Math.max(0, res[u]));
    }
    for (int v : ad[u]) if (p != v) {
        reroot(v, u);
    }
}