void main1() throws NumberFormatException, IOException {
    int n = input.nextInt();
    int m = input.nextInt();
    color = new int[n];
    g = allocateArrayList(n);
    for (int i = 0; i < m; i++) {
        int x = input.nextInt() - 1;
        int y = input.nextInt() - 1;
        g[x].add(y);
        g[y].add(x);
    }
    boolean[][] cant = new boolean[4][n];
    ArrayList<Integer>[] clrs = allocateArrayList(4);
    for (int c = 1; c < 4; c++) {
        vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                vis[i] = true;
                while (!q.isEmpty()) {
                    int cur = q.poll();
                    if (!cant[c][cur] && color[cur] == 0) {
                        color[cur] = c;
                        clrs[c].add(cur);
                    }
                    for (int v : g[cur]) {
                        cant[color[cur]][v] = true;
                        cant[color[v]][cur] = true;
                        if (!vis[v]) {
                            vis[v] = true;
                            q.add(v);
                        }
                    }
                }
            }
        }
    }
    for (int i = 0; i < n; i++) {
        boolean ruined = false;
        int[] f = new int[4];
        for (int v : g[i]) {
            f[color[v]]++;
        }
        for (int j = 1; j < 4; j++) {
            if (color[i] == j && f[j] != 0) {
                ruined = true;
            }
            if (color[i] == j)
                continue;
            if (f[j] != clrs[j].size() || clrs[j].size() == 0)
                ruined = true;
        }
        if (color[i] == 0 || ruined) {
            out.println(-1);
            out.flush();
            return;
        }
    }
    for (int i = 0; i < n; i++) {
        out.print(color[i] + " ");
    }
    out.flush();
}