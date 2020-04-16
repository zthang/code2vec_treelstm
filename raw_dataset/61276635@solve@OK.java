public void solve(int testNumber, InputReader in, PrintWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[][] arr = new int[7][7];
    for (int i = 0; i < m; i++) {
        int x = in.nextInt() - 1;
        int y = in.nextInt() - 1;
        arr[x][y] = 1;
        arr[y][x] = 1;
    }
    if (n <= 6) {
        out.println(m);
        return;
    }
    int ans = 0;
    for (int i = 0; i < 7; i++) {
        for (int j = 0; j < 7; j++) {
            int s = 0;
            for (int k = 0; k < 7; k++) {
                if (arr[i][k] == 1 && arr[j][k] == 1) {
                    s++;
                // System.out.println(s+" "+i+ " "+k);
                }
            }
            if (m - s > ans) {
                ans = m - s;
            }
        }
    }
    out.println(ans);
}