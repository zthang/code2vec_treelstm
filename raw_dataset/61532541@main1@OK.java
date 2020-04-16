void main1() throws NumberFormatException, IOException {
    int n = input.nextInt();
    int m = input.nextInt();
    color = new int[n];
    vis = new boolean[n];
    g = allocateArrayList(n);
    dada = allocateArrayList(4);
    for (int i = 0; i < m; i++) {
        int x = input.nextInt() - 1;
        int y = input.nextInt() - 1;
        g[x].add(y);
        g[y].add(x);
    }
    for (int i = 0; i < n; i++) {
        if (!vis[i]) {
            bfs(i, 1);
        }
    }
    vis = new boolean[n];
    for (int i = 0; i < n; i++) {
        if (!vis[i]) {
            bfs(i, 2);
        }
    }
    vis = new boolean[n];
    for (int i = 0; i < n; i++) {
        if (!vis[i]) {
            bfs(i, 3);
        }
    }
    // out.println(Arrays.toString(color));
    if (dada[1].size() + dada[2].size() + dada[3].size() != n || dada[1].size() == 0 || dada[3].size() == 0 || dada[2].size() == 0) {
        out.println(-1);
    } else {
        if (check()) {
            for (int i = 0; i < n; i++) {
                out.print(color[i] + " ");
            }
        } else {
            out.println(-1);
        }
    }
    out.flush();
}