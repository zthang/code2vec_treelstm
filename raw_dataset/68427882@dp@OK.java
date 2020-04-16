int dp(int side, int n, int dist) {
    if (n > N)
        return 0;
    if (memo[side][n][dist] != -1)
        return memo[side][n][dist];
    int res = 987654321, a = connA[n], b = connB[n];
    if (side == 0) {
        // gap given between side A
        // assign to side A
        int prev = connA[n - dist];
        int cost = depA[a] - depA[lcaA[a][prev]];
        res = Math.min(res, cost + dp(1, n + 1, 2));
        // assign to side B
        prev = connB[n - 1];
        cost = depB[b] - depB[lcaB[b][prev]];
        res = Math.min(res, cost + dp(0, n + 1, dist + 1));
    } else {
        // gap given between side B
        // assign to side A
        int prev = connA[n - 1];
        int cost = depA[a] - depA[lcaA[a][prev]];
        res = Math.min(res, cost + dp(1, n + 1, dist + 1));
        // assign to side B
        prev = connB[n - dist];
        cost = depB[b] - depB[lcaB[b][prev]];
        res = Math.min(res, cost + dp(0, n + 1, 2));
    }
    return memo[side][n][dist] = res;
}