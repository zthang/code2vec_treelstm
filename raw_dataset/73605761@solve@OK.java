static void solve(int s, int[] b, int[] w, int parent, int[] a, int[] ans) {
    Iterator<Integer> itr = adj[s].listIterator();
    while (itr.hasNext()) {
        int n = itr.next();
        if (n != parent) {
            if (w[s] > b[s]) {
                int x = b[s], y = w[s];
                if (w[n] > b[n]) {
                    x = b[s] - b[n];
                    y = w[s] - w[n];
                }
                if (y > x) {
                    b[n] = b[n] + x;
                    w[n] = w[n] + y;
                }
            }
            ans[n] = w[n] - b[n];
            solve(n, b, w, s, a, ans);
        }
    }
}