private static void solve(int q, FastScanner in, PrintWriter out) {
    for (int qq = 0; qq < q; qq++) {
        int n = in.nextInt();
        stop = new int[n][n][2];
        xCnt = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                stop[i][j][0] = in.nextInt() - 1;
                stop[i][j][1] = in.nextInt() - 1;
            }
        }
        boolean valid = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (stop[i][j][0] >= 0 && stop[i][j][1] >= 0) {
                    if (stop[stop[i][j][0]][stop[i][j][1]][0] != stop[i][j][0] || stop[stop[i][j][0]][stop[i][j][1]][1] != stop[i][j][1]) {
                        valid = false;
                        break;
                    }
                    int d = stop[i][j][0] * n + stop[i][j][1];
                    xCnt.put(d, xCnt.getOrDefault(d, 0) + 1);
                }
            }
            if (!valid) {
                break;
            }
        }
        if (valid) {
            grid = new char[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(grid[i], '*');
            }
            for (int x : xCnt.keySet()) {
                if (!bfs(x)) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (grid[i][j] == '*') {
                            char direction1 = '*', direction2 = '*';
                            for (int k = 0; k < 4; k++) {
                                int x = i + dx[k];
                                int y = j + dy[k];
                                if (x >= 0 && x < n && y >= 0 && y < n && stop[x][y][0] < 0) {
                                    if (grid[x][y] != '*' && direction1 == '*') {
                                        direction1 = dir[k];
                                    } else if (grid[x][y] == '*' && direction2 == '*') {
                                        direction2 = dir[k];
                                    }
                                }
                            }
                            if (direction1 == '*' && direction2 == '*') {
                                valid = false;
                                break;
                            } else if (direction1 != '*') {
                                grid[i][j] = direction1;
                            } else {
                                grid[i][j] = direction2;
                            }
                        }
                    }
                    if (!valid) {
                        break;
                    }
                }
            }
        }
        out.println(valid ? "VALID" : "INVALID");
        if (valid) {
            for (int i = 0; i < grid.length; i++) {
                out.println(String.valueOf(grid[i]));
            }
        }
    }
    out.close();
}