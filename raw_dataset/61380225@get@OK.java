int get() {
    for (int i = 0; i < can.length; i++) Arrays.fill(can[i], false);
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
            int x = a[i], y = a[j];
            if (y < x) {
                int tmp = x;
                x = y;
                y = tmp;
            }
            can[x][y] |= g[i][j];
        }
    }
    int ans = 0;
    for (int i = 1; i <= C; ++i) {
        for (int j = 1; j <= C; ++j) ans += (can[i][j] == true ? 1 : 0);
    }
    return ans;
}