public void dfs(int x) {
    visit[x] = 1;
    int t1 = 0, t2 = 0;
    for (int y : adj[x]) {
        if (visit[y] == 0) {
            dfs(y);
            t1 += Math.max(0, wrr[y]);
            t2 += Math.max(0, brr[y]);
        }
    }
    if (col[x] == 1) {
        t1--;
        t2++;
    } else {
        t2--;
        t1++;
    }
    wrr[x] = t1;
    brr[x] = t2;
}