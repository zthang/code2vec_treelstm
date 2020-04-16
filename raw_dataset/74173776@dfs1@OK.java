static void dfs1(int nd, int pr) {
    dp1[nd] = (arr[nd] == 1) ? 1 : -1;
    for (Integer ch : adj[nd]) {
        if (ch == pr)
            continue;
        dfs1(ch, nd);
        dp1[nd] += Math.max(0, dp1[ch]);
    }
}