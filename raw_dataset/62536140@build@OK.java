private static void build(int idx, int par, int c1, int c2) {
    if (adj[idx].size() == 1 && par != -1) {
        long sol = Long.MAX_VALUE / 3;
        int col = -1;
        if (c1 != 0 && c2 != 0 && sol > a[idx]) {
            sol = Math.min(sol, a[idx]);
            col = 1;
        }
        if (c1 != 1 && c2 != 1) {
            sol = Math.min(sol, b[idx]);
            col = 2;
        }
        if (c1 != 2 && c2 != 2) {
            sol = Math.min(sol, c[idx]);
            col = 3;
        }
        SOL[idx] = col;
        return;
    }
    int col = -1;
    int next = -1;
    long sol = Long.MAX_VALUE / 3;
    for (int i : adj[idx]) {
        if (i == par)
            continue;
        next = i;
        long tmp;
        if (c1 != 0 && c2 != 0) {
            tmp = solve(i, idx, c2, 0) + a[idx];
            if (tmp < sol) {
                sol = tmp;
                col = 1;
            }
        }
        if (c1 != 1 && c2 != 1) {
            tmp = solve(i, idx, c2, 1) + b[idx];
            if (tmp < sol) {
                sol = tmp;
                col = 2;
            }
        }
        if (c1 != 2 && c2 != 2) {
            tmp = solve(i, idx, c2, 2) + c[idx];
            if (tmp < sol) {
                sol = tmp;
                col = 3;
            }
        }
    }
    SOL[idx] = col;
    build(next, idx, c2, col - 1);
}