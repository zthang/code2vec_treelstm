static void solve(int a, int b) {
    ans[a][b] = 'X';
    Queue<pair> q = new LinkedList<>();
    q.add(new pair(a, b));
    while (q.size() > 0) {
        int i = q.peek().f, j = q.peek().s;
        q.poll();
        if (i > n || i == 0 || j > n || j == 0) {
            continue;
        }
        for (int k = 0; k < 4; k++) {
            int a1 = mat[i + x[k]][j + y[k]].f, b1 = mat[i + x[k]][j + y[k]].s;
            if (a1 == a && b1 == b) {
                if (ans[i + x[k]][j + y[k]] == null) {
                    ans[i + x[k]][j + y[k]] = d[3 - k];
                    q.add(new pair(i + x[k], j + y[k]));
                }
            }
        }
    }
}