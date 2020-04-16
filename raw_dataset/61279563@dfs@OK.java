static void dfs(int id) {
    if (id == N) {
        int cur = 0;
        boolean[][] used = new boolean[6][6];
        for (Edge e : edges) {
            int a = Math.min(ar[e.a], ar[e.b]);
            int b = Math.max(ar[e.a], ar[e.b]);
            if (!used[a][b]) {
                cur++;
                used[a][b] = true;
            }
        }
        max = Math.max(max, cur);
    } else {
        for (int val = 0; val < 6; val++) {
            ar[id] = val;
            dfs(id + 1);
        }
    }
}