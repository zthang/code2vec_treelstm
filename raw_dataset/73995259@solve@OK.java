static void solve(int a, int b) {
    ans[a][b] = 'X';
    Queue<pair> q = new LinkedList<>();
    q.add(new pair(a, b));
    while (q.size() > 0) {
        int i = q.peek().f, j = q.peek().s;
        q.poll();
        for (int k = 0; k < 4; k++) {
            int i1 = i + x[k], j1 = j + y[k];
            int a1 = mat[i1][j1].f, b1 = mat[i1][j1].s;
            if (a1 == a && b1 == b && ans[i1][j1].equals('0')) {
                ans[i1][j1] = d[3 - k];
                q.add(new pair(i1, j1));
            }
        }
    }
}