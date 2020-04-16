int go(int[] a) {
    int m = a.length;
    for (int i = 1; i <= m; i++) {
        if (m % i != 0)
            continue;
        boolean[] vis = new boolean[m];
        for (int j = 0; j < m; j++) {
            if (vis[j])
                continue;
            int k = j;
            boolean good = true;
            while (!vis[k]) {
                if (a[k] != a[j]) {
                    good = false;
                }
                vis[k] = true;
                k = (k + i) % m;
            }
            if (good) {
                return i;
            }
        }
    }
    return m;
}