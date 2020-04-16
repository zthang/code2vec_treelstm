public void solve() {
    boolean[] vis = new boolean[n];
    int[] ans = new int[n];
    int cnt = 0;
    for (int i = 0; i < n; i++) {
        if (!vis[i]) {
            if (cnt++ == 3) {
                System.out.println(-1);
                return;
            }
            boolean[] curvis = new boolean[n];
            for (int v : adj[i]) {
                curvis[v] = true;
            }
            for (int j = 0; j < n; j++) {
                if (!curvis[j]) {
                    if (vis[j]) {
                        System.out.println(-1);
                        return;
                    }
                    vis[j] = true;
                    ans[j] = cnt;
                    if (adj[j].size() != adj[i].size()) {
                        System.out.println(-1);
                        return;
                    }
                    for (int v : adj[j]) {
                        if (!curvis[v]) {
                            System.out.println(-1);
                            return;
                        }
                    }
                }
            }
        }
    }
    if (cnt != 3) {
        System.out.println(-1);
        return;
    }
    for (int i = 0; i < n; i++) {
        System.out.print(ans[i] + " ");
    }
    System.out.println();
}