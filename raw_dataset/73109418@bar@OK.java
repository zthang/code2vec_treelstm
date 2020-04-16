private static void bar(int now, int[] col, int[] par, int[] ans, HashSet<Integer>[] adj, int[] ans2) {
    int stSum = ans[now], pSum = ans2[par[now]];
    if (stSum > 0)
        pSum -= stSum;
    if (pSum > 0)
        stSum += pSum;
    ans2[now] = stSum;
    for (Integer child : adj[now]) if (par[now] != child) {
        bar(child, col, par, ans, adj, ans2);
    }
}