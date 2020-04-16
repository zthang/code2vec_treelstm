public void solve() {
    int n = in.nextInt();
    int moves = in.nextInt() / 2;
    int[][] edge = new int[n][n];
    for (int i = 0; i < edge.length; i++) {
        for (int j = 0; j < edge.length; j++) {
            edge[i][j] = in.nextInt();
        }
    }
    int nmin = 5;
    int[][][] twoMove = new int[n][n][nmin];
    int[][][] through = new int[n][n][nmin];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            for (int min = 0; min < nmin; min++) {
                twoMove[i][j][min] = Integer.MAX_VALUE / 2;
                through[i][j][min] = -1;
            }
            for (int th = 1; th < n; th++) {
                if (th == i || th == j) {
                    continue;
                }
                int len = edge[i][th] + edge[th][j];
                for (int l = 0; l < nmin; l++) {
                    if (len < twoMove[i][j][l]) {
                        for (int k = nmin - 1; k > l; k--) {
                            twoMove[i][j][k] = twoMove[i][j][k - 1];
                            through[i][j][k] = through[i][j][k - 1];
                        }
                        twoMove[i][j][l] = len;
                        through[i][j][l] = th;
                        break;
                    }
                }
            }
        }
    }
    if (moves == 1) {
        out.print(twoMove[0][0][0]);
        return;
    }
    if (moves == 5) {
        int ans = Integer.MAX_VALUE / 2;
        for (int b = 0; b < n; b++) {
            for (int d = 0; d < n; d++) {
                for (int f = 0; f < n; f++) {
                    for (int h = 0; h < n; h++) {
                        int th = 0;
                        int[] route = { 0, b, d, f, h, 0 };
                        for (int j = 0; j < moves; j++) {
                            int from = route[j];
                            int to = route[j + 1];
                            for (int i = 0; i < nmin; i++) {
                                if (through[from][to][i] == b || through[from][to][i] == d || through[from][to][i] == f || through[from][to][i] == h) {
                                    continue;
                                }
                                th += twoMove[from][to][i];
                                break;
                            }
                        }
                        ans = Math.min(ans, th);
                    }
                }
            }
        }
        out.print(ans);
        return;
    }
    if (moves == 4) {
        int ans = Integer.MAX_VALUE / 2;
        for (int b = 0; b < n; b++) {
            for (int d = 0; d < n; d++) {
                for (int f = 0; f < n; f++) {
                    int th = 0;
                    int[] route = { 0, b, d, f, 0 };
                    for (int j = 0; j < moves; j++) {
                        int from = route[j];
                        int to = route[j + 1];
                        for (int i = 0; i < nmin; i++) {
                            if (through[from][to][i] == b || through[from][to][i] == d || through[from][to][i] == f) {
                                continue;
                            }
                            th += twoMove[from][to][i];
                            break;
                        }
                    }
                    ans = Math.min(ans, th);
                }
            }
        }
        out.print(ans);
        return;
    }
    if (moves == 3) {
        int ans = Integer.MAX_VALUE / 2;
        for (int b = 0; b < n; b++) {
            for (int d = 0; d < n; d++) {
                int th = 0;
                int[] route = { 0, b, d, 0 };
                for (int j = 0; j < moves; j++) {
                    int from = route[j];
                    int to = route[j + 1];
                    for (int i = 0; i < nmin; i++) {
                        if (through[from][to][i] == b || through[from][to][i] == d) {
                            continue;
                        }
                        th += twoMove[from][to][i];
                        break;
                    }
                }
                ans = Math.min(ans, th);
            }
        }
        out.print(ans);
        return;
    }
    if (moves == 2) {
        int ans = Integer.MAX_VALUE / 2;
        for (int b = 0; b < n; b++) {
            int th = 0;
            int[] route = { 0, b, 0 };
            for (int j = 0; j < moves; j++) {
                int from = route[j];
                int to = route[j + 1];
                for (int i = 0; i < nmin; i++) {
                    if (through[from][to][i] == b) {
                        continue;
                    }
                    th += twoMove[from][to][i];
                    break;
                }
            }
            ans = Math.min(ans, th);
        }
        out.print(ans);
        return;
    }
}