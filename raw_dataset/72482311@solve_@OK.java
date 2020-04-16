private void solve_(Pair<Integer, Integer> pf, Pair<Integer, Integer>[][] pp, char[][] str) {
    int n = pp[0].length;
    str[pf.first][pf.second] = 'X';
    LinkedList<Pair<Integer, Integer>> q = new LinkedList<>();
    int x = pf.first, y = pf.second;
    q.add(pf);
    while (!q.isEmpty()) {
        Pair<Integer, Integer> ps = q.pollFirst();
        int xx = ps.first, yy = ps.second;
        for (int i = 0; i < 4; i++) {
            if (xx + dx[i] >= 0 && xx + dx[i] < n && yy + dy[i] >= 0 && yy + dy[i] < n && pp[xx + dx[i]][yy + dy[i]].first == x && pp[xx + dx[i]][yy + dy[i]].second == y && str[xx + dx[i]][yy + dy[i]] == '.') {
                if (i == 0) {
                    str[xx + dx[i]][yy + dy[i]] = 'U';
                } else if (i == 1) {
                    str[xx + dx[i]][yy + dy[i]] = 'L';
                } else if (i == 2) {
                    str[xx + dx[i]][yy + dy[i]] = 'D';
                } else {
                    str[xx + dx[i]][yy + dy[i]] = 'R';
                }
                q.add(new Pair<>(xx + dx[i], yy + dy[i]));
            }
        }
    }
}