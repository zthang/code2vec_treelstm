static long f(int idx, int mask) {
    if (idx == n) {
        return 0;
    }
    if (dp[idx][mask] != -1) {
        return dp[idx][mask];
    }
    int prev_color = mask % 4;
    int prev_prev_color = mask / 4;
    long min = Long.MAX_VALUE;
    int node = nodes.get(idx);
    for (int color = 1; color <= 3; ++color) {
        if (color != prev_color && color != prev_prev_color) {
            long ispe = f(idx + 1, prev_color * 4 + color) + c[color - 1][node];
            if (ispe < min) {
                min = ispe;
                which[node][mask] = color;
            }
        }
    }
    return dp[idx][mask] = min;
}