public void dfs1(int x, int w, int b) {
    // System.out.println(x+" "+w+" "+b);
    wrr[x] += Math.max(0, w);
    brr[x] += Math.max(0, b);
    visit[x] = 1;
    w = Math.max(w, 0);
    b = Math.max(b, 0);
    for (int y : adj[x]) {
        if (visit[y] == 0) {
            w += Math.max(0, wrr[y]);
            b += Math.max(0, brr[y]);
        }
    }
    if (col[x] == 1) {
        w--;
        b++;
    } else {
        b--;
        w++;
    }
    for (int y : adj[x]) if (visit[y] == 0)
        dfs1(y, w - Math.max(0, wrr[y]), b - Math.max(0, brr[y]));
}