void solve() throws IOException {
    String[] buf = reader.readLine().split(" ");
    int n = Integer.parseInt(buf[0]);
    int[][][] end = new int[n][n][];
    List<int[]>[][] sameEnd = new List[n][n];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) sameEnd[i][j] = new ArrayList<>();
    }
    for (int i = 0; i < n; i++) {
        buf = reader.readLine().split(" ");
        for (int j = 0; j < n; j++) {
            int rend = Integer.parseInt(buf[2 * j]) - 1, cend = Integer.parseInt(buf[2 * j + 1]) - 1;
            end[i][j] = new int[] { rend, cend };
            // if not infinite loop
            if (rend >= 0 && cend >= 0)
                sameEnd[rend][cend].add(new int[] { i, j });
        }
    }
    // first check
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (sameEnd[i][j].size() > 0) {
                if (end[i][j][0] != i || end[i][j][1] != j) {
                    out.println("INVALID");
                    return;
                }
            }
        }
    }
    char[][] res = new char[n][n];
    boolean[][] vis = new boolean[n][n];
    // firstly handle the end case
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            // this is not an end that we want
            if (end[i][j][0] != i || end[i][j][1] != j)
                continue;
            int temp = singleSource(n, end, sameEnd[i][j], i, j, res, vis);
            if (temp < 0) {
                out.println("INVALID");
                return;
            }
        }
    }
    // all the non loop cells should have been visited
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (end[i][j][0] >= 0)
                continue;
            // since they are loops. overwriting doesn't matter
            boolean flag = false;
            for (int k = 0; k < 4 && (!flag); k++) {
                int r = i + dr[k], c = j + dc[k];
                if (r < 0 || r >= n || c < 0 || c >= n || end[r][c][0] >= -1)
                    continue;
                flag = true;
                res[i][j] = dirTo[k];
            }
            if (!flag) {
                out.println("INVALID");
                return;
            }
        }
    }
    out.println("VALID");
    for (int i = 0; i < n; i++) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < n; j++) sb.append(res[i][j]);
        out.println(sb.toString());
    }
}