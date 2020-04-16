static void dfsAns(int v, int p) {
    long max = 0;
    HashSet<Integer> seen = new HashSet<>();
    for (int edge : aux[v]) {
        if (edge == p || seen.contains(edge))
            continue;
        seen.add(edge);
        dfsAns(edge, v);
        if (hasCycleChild[edge])
            hasCycleChild[v] = true;
        sum[v] += sum[edge];
        max = Math.max(dp[edge], max);
    }
    dp[v] = max;
    if (colsz[v] > 1) {
        hasCycleChild[v] = true;
    } else if (!hasCycleChild[v]) {
        dp[v] += colSums[v];
    }
    if (hasCycleChild[v]) {
        sum[v] += colSums[v];
    }
}