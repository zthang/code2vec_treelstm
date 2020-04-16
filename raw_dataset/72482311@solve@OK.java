public void solve(int testNumber, InputReader c, OutputWriter w) {
    int n = c.readInt();
    Pair<Integer, Integer>[][] pp = new Pair[n][n];
    char[][] str = new char[n][n];
    LinkedList<Pair<Integer, Integer>> pqr = new LinkedList<>();
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            int u = c.readInt() - 1, v = c.readInt() - 1;
            pp[i][j] = new Pair<>(u, v);
            if (pp[i][j].first == i && pp[i][j].second == j) {
                pqr.add(pp[i][j]);
            }
            if (pp[i][j].first == -2) {
                for (int jj = 0; jj < 4; jj++) {
                    if (u + dx[jj] >= 0 && u + dx[jj] < n && v + dy[jj] >= 0 && v + dy[jj] < n && pp[u + dx[jj]][v + dy[jj]].first != -2) {
                        w.printLine("INVALID");
                        return;
                    }
                }
            }
            str[i][j] = '.';
        }
    }
    while (!pqr.isEmpty()) {
        solve_(pqr.pollFirst(), pp, str);
    }
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (str[i][j] == '.' && pp[i][j].first != -2) {
                w.printLine("INVALID");
                return;
            }
        }
    }
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (str[i][j] == '.') {
                boolean found = false;
                for (int k = 0; k < 4; k++) {
                    int xxx = i + ddx[k], yyy = j + ddy[k];
                    if (xxx >= 0 && xxx < n && yyy >= 0 && yyy < n && pp[xxx][yyy].first == -2) {
                        found = true;
                        if (k == 0) {
                            str[i][j] = 'L';
                            break;
                        } else if (k == 1) {
                            str[i][j] = 'U';
                            break;
                        } else if (k == 2) {
                            str[i][j] = 'R';
                            break;
                        } else {
                            str[i][j] = 'D';
                        }
                    }
                }
                if (!found) {
                    w.printLine("INVALID");
                    return;
                }
            }
        }
    }
    w.printLine("VALID");
    for (int i = 0; i < n; i++) {
        w.printLine(new String(str[i]));
    }
}