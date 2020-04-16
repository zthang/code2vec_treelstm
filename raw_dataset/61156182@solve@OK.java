public void solve(int testNumber, FastReader s, PrintWriter w) {
    int n = s.nextInt(), m = s.nextInt();
    ArrayList<Integer>[] t = new ArrayList[n];
    if (n != 7) {
        w.println(m);
        return;
    }
    int[][] f = new int[n][n];
    for (int i = 0; i < n; i++) {
        t[i] = new ArrayList<>();
        f[i][1] = i;
    }
    for (int i = 0; i < m; i++) {
        int x = s.nextInt() - 1, y = s.nextInt() - 1;
        t[x].add(y);
        t[y].add(x);
        f[x][0]++;
        f[y][0]++;
    }
    int[] perm = { 1, 1, 2, 3, 4, 5, 6 };
    permute(perm, 0, 6);
    int max = 0;
    for (int[] per : p) {
        int ans = 0;
        boolean[][] done = new boolean[7][7];
        for (int i = 0; i < n; i++) {
            for (int cur : t[i]) {
                if (!done[per[i]][per[cur]]) {
                    ans++;
                    done[per[i]][per[cur]] = true;
                    done[per[cur]][per[i]] = true;
                }
            }
        }
        max = Math.max(ans, max);
    }
    w.println(max);
}