private static void foo(int now, int[] col, int[] par, int[] ans, HashSet<Integer>[] adj) {
    for (Integer child : adj[now]) if (par[now] != child) {
        par[child] = now;
        foo(child, col, par, ans, adj);
        if (ans[child] > 0)
            ans[now] += ans[child];
    }
}