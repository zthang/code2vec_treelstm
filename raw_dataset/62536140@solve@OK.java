private static long solve(int idx, int par, int c1, int c2) {
    if (adj[idx].size() == 1 && par != -1) {
        long sol = Long.MAX_VALUE / 3;
        if (c1 != 0 && c2 != 0)
            sol = Math.min(sol, a[idx]);
        if (c1 != 1 && c2 != 1)
            sol = Math.min(sol, b[idx]);
        if (c1 != 2 && c2 != 2)
            sol = Math.min(sol, c[idx]);
        return memo[c1][c2][idx] = sol;
    }
    if (memo[c1][c2][idx] != -1) {
        return memo[c1][c2][idx];
    }
    long sol = Long.MAX_VALUE / 3;
    for (int i : adj[idx]) {
        if (i == par)
            continue;
        if (c1 != 0 && c2 != 0)
            sol = Math.min(sol, solve(i, idx, c2, 0) + a[idx]);
        if (c1 != 1 && c2 != 1)
            sol = Math.min(sol, solve(i, idx, c2, 1) + b[idx]);
        if (c1 != 2 && c2 != 2)
            sol = Math.min(sol, solve(i, idx, c2, 2) + c[idx]);
    }
    return memo[c1][c2][idx] = sol;
}