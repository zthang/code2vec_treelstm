static long dfs(int n, long tot) {
    visited[n] = true;
    long cnt = 1;
    for (int i = 0; i < a[n].size(); i++) {
        pair p = (pair) a[n].get(i);
        if (!visited[p.x]) {
            long got = dfs(p.x, tot);
            if (got % 2 == 1) {
                mini += p.y;
            }
            cnt += got;
            maxi += Math.min(got, tot - got) * p.y;
        }
    }
    return cnt;
}