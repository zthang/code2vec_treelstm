public void solve(int testNumber, InputReader in, PrintWriter out) {
    int T = in.nextInt();
    for (int test = 0; test < T; test++) {
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            a[i] = new int[] { x, i + 1 };
        }
        Arrays.sort(a, new Comparator<int[]>() {

            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0])
                    return o1[0] < o2[0] ? -1 : 1;
                if (o1[1] != o2[1])
                    return o1[1] < o2[1] ? -1 : 1;
                return 0;
            }
        });
        if (m < 3 || m < n) {
            out.println(-1);
        } else {
            int ans = 0;
            for (int i = 0; i < m; i++) ans += a[i][0];
            out.println(ans * 2);
            for (int i = 0; i < m; i++) {
                int nxt = (i + 1) % m;
                out.println(a[i][1] + " " + a[nxt][1]);
            }
        }
    }
}