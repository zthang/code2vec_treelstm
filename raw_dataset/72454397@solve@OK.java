static void solve() {
    int n = in.nextInt();
    int[][][] a = new int[n][n][2];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            int r = in.nextInt();
            int c = in.nextInt();
            if (r == -1 && c == -1) {
                a[i][j][0] = a[i][j][1] = -1;
            } else {
                a[i][j][0] = r - 1;
                a[i][j][1] = c - 1;
            }
        }
    }
    char[][] ans = new char[n][n];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            ans[i][j] = '#';
            if (a[i][j][0] == i && a[i][j][1] == j) {
                ans[i][j] = 'X';
            }
        }
    }
    int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (ans[i][j] == 'X') {
                LinkedList<Cell> q = new LinkedList<>();
                q.addLast(new Cell(i, j));
                while (!q.isEmpty()) {
                    Cell c = q.pollFirst();
                    for (int[] d : dirs) {
                        int i1 = c.i + d[0];
                        int j1 = c.j + d[1];
                        if (i1 >= 0 && i1 < n && j1 >= 0 && j1 < n) {
                            if (a[i1][j1][0] == i && a[i1][j1][1] == j && ans[i1][j1] == '#') {
                                if (d[0] == -1 && d[1] == 0) {
                                    ans[i1][j1] = 'D';
                                } else if (d[0] == 0 && d[1] == 1) {
                                    ans[i1][j1] = 'L';
                                } else if (d[0] == 1 && d[1] == 0) {
                                    ans[i1][j1] = 'U';
                                } else if (d[0] == 0 && d[1] == -1) {
                                    ans[i1][j1] = 'R';
                                }
                                q.addLast(new Cell(i1, j1));
                            }
                        }
                    }
                }
            }
        }
    }
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (ans[i][j] == '#') {
                if (a[i][j][0] != -1 && a[i][j][1] != -1) {
                    out.println("INVALID");
                    return;
                }
                int cnt = 0;
                for (int[] d : dirs) {
                    int i1 = i + d[0];
                    int j1 = j + d[1];
                    if (i1 >= 0 && i1 < n && j1 >= 0 && j1 < n) {
                        if (ans[i1][j1] == '#') {
                            if (d[0] == -1 && d[1] == 0) {
                                ans[i][j] = 'U';
                            } else if (d[0] == 0 && d[1] == 1) {
                                ans[i][j] = 'R';
                            } else if (d[0] == 1 && d[1] == 0) {
                                ans[i][j] = 'D';
                            } else if (d[0] == 0 && d[1] == -1) {
                                ans[i][j] = 'L';
                            }
                            cnt++;
                        }
                    }
                }
                // out.println(i + " " + j + " " + ans[i][j]);
                if (cnt == 0) {
                    out.println("INVALID");
                    return;
                }
                LinkedList<Cell> q = new LinkedList<>();
                q.addLast(new Cell(i, j));
                while (!q.isEmpty()) {
                    Cell c = q.pollFirst();
                    for (int[] d : dirs) {
                        int i1 = c.i + d[0];
                        int j1 = c.j + d[1];
                        if (i1 >= 0 && i1 < n && j1 >= 0 && j1 < n) {
                            if (a[i1][j1][0] == -1 && a[i1][j1][1] == -1 && ans[i1][j1] == '#') {
                                if (d[0] == -1 && d[1] == 0) {
                                    ans[i1][j1] = 'D';
                                } else if (d[0] == 0 && d[1] == 1) {
                                    ans[i1][j1] = 'L';
                                } else if (d[0] == 1 && d[1] == 0) {
                                    ans[i1][j1] = 'U';
                                } else if (d[0] == 0 && d[1] == -1) {
                                    ans[i1][j1] = 'R';
                                }
                                q.addLast(new Cell(i1, j1));
                            }
                        }
                    }
                }
            }
        }
    }
    out.println("VALID");
    print(ans);
}