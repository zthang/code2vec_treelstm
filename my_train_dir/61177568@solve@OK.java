void solve() {
    int n = scn.nextInt(), m = scn.nextInt();
    int[] from = new int[m], to = new int[m];
    int lim = 1;
    for (int i = 0; i < n; i++) {
        lim *= 7;
    }
    for (int i = 0; i < m; i++) {
        from[i] = scn.nextInt() - 1;
        to[i] = scn.nextInt() - 1;
    }
    int ans = 0;
    for (int i = 0; i <= lim; i++) {
        int[] col = new int[n];
        int k = i;
        for (int j = 0; j < n; j++) {
            col[j] = k % 7;
            k /= 7;
        }
        boolean[][] done = new boolean[7][7];
        int z = 0;
        for (int e = 0; e < m; e++) {
            int x = col[from[e]], y = col[to[e]];
            if (x * y == 0) {
                continue;
            }
            int min = Math.min(x, y);
            int max = Math.max(x, y);
            if (!done[min][max]) {
                done[min][max] = true;
                z++;
            }
        }
        ans = Math.max(ans, z);
    }
    out.println(ans);
}