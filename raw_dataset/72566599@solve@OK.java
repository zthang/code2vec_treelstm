void solve() {
    int N = ni();
    int[][][] a = new int[N][N][];
    char[][] ans = new char[N][N];
    for (int r = 0; r < N; r++) for (int c = 0; c < N; c++) a[r][c] = new int[] { ni(), ni() };
    int[][] dirs = new int[][] { { 1, 0, 'U', 'D' }, { -1, 0, 'D', 'U' }, { 0, 1, 'L', 'R' }, { 0, -1, 'R', 'L' } };
    for (int r = 0; r < N; r++) for (int c = 0; c < N; c++) {
        if (a[r][c][0] == r + 1 && a[r][c][1] == c + 1) {
            ans[r][c] = 'X';
            ArrayDeque<int[]> q = new ArrayDeque<int[]>();
            q.add(new int[] { r, c, (r + 1) * N + (c + 1) });
            while (!q.isEmpty()) {
                int[] p = q.poll();
                for (int[] d : dirs) {
                    int[] p2 = new int[] { p[0] + d[0], p[1] + d[1] };
                    if (p2[0] >= 0 && p2[0] < N && p2[1] >= 0 && p2[1] < N && a[p2[0]][p2[1]][0] * N + a[p2[0]][p2[1]][1] == p[2] && ans[p2[0]][p2[1]] == '\0') {
                        ans[p2[0]][p2[1]] = (char) d[2];
                        q.add(new int[] { p2[0], p2[1], p[2] });
                    }
                }
            }
        }
    }
    for (int r = 0; r < N; r++) for (int c = 0; c < N; c++) {
        if (a[r][c][0] == -1 && ans[r][c] == '\0') {
            for (int[] d : dirs) {
                int[] p2 = new int[] { r + d[0], c + d[1] };
                if (p2[0] >= 0 && p2[0] < N && p2[1] >= 0 && p2[1] < N && a[p2[0]][p2[1]][0] == -1) {
                    if (ans[p2[0]][p2[1]] != '\0')
                        ans[p2[0]][p2[1]] = (char) d[2];
                    ans[r][c] = (char) d[3];
                }
            }
        }
        if (ans[r][c] == '\0') {
            out.println("INVALID");
            return;
        }
    }
    out.println("VALID");
    for (int r = 0; r < N; r++) out.println(new String(ans[r]));
}