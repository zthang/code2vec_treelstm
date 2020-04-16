static int f(int idx, int prev, int prev_len) {
    if (idx == n + 1) {
        return 0;
    }
    if (dp[idx][prev][prev_len] != -1) {
        return dp[idx][prev][prev_len];
    }
    int one, two;
    if (prev == 0) {
        one = f(idx + 1, 1, 1) + level[0][arr[0][idx]] - 1;
        two = f(idx + 1, 2, 1) + level[1][arr[1][idx]] - 1;
    } else if (prev == 1) {
        int one_nodes = level[0][arr[0][idx]] - level[0][lca[0][arr[0][idx]][arr[0][idx - 1]]];
        // pl("idx : "+idx+" prev : "+prev+" prev_len : "+prev_len+ " One nodes needed : "+one_nodes);
        one = f(idx + 1, 1, prev_len + 1) + one_nodes;
        int two_nodes = (prev_len == (idx - 1) ? level[1][arr[1][idx]] - 1 : level[1][arr[1][idx]] - level[1][lca[1][arr[1][idx]][arr[1][idx - prev_len - 1]]]);
        // pl("idx : "+idx+" prev : "+prev+" prev_len : "+prev_len+ " Two nodes needed : "+two_nodes);
        two = f(idx + 1, 2, 1) + two_nodes;
    } else {
        int one_nodes = (prev_len == (idx - 1) ? level[0][arr[0][idx]] - 1 : level[0][arr[0][idx]] - level[0][lca[0][arr[0][idx]][arr[0][idx - prev_len - 1]]]);
        one = f(idx + 1, 1, 1) + one_nodes;
        // pl("idx : "+idx+" prev : "+prev+" prev_len : "+prev_len+ " One nodes needed : "+one_nodes);
        int two_nodes = level[1][arr[1][idx]] - level[1][lca[1][arr[1][idx]][arr[1][idx - 1]]];
        // pl("idx : "+idx+" prev : "+prev+" prev_len : "+prev_len+ " Two nodes needed : "+two_nodes);
        two = f(idx + 1, 2, prev_len + 1) + two_nodes;
    }
    return dp[idx][prev][prev_len] = min(one, two);
}