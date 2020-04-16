public void solve(int testNumber, InputReader in, PrintWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    List<Pair> c = new ArrayList<>();
    for (int i = 0; i < m; i++) {
        int x = in.nextInt();
        int y = in.nextInt();
        c.add(new Pair(x - 1, y - 1));
    }
    int ans = 0;
    for (int i = 279936; i < 559872; i++) {
        boolean[][] d = new boolean[6][6];
        String s = getCur(i);
        int curr = 0;
        for (Pair x : c) {
            int j = s.charAt(x.x) - '0';
            int k = s.charAt(x.y) - '0';
            if (!d[j][k]) {
                d[j][k] = true;
                d[k][j] = true;
                curr++;
            }
        }
        ans = Math.max(ans, curr);
    }
    out.println(ans);
}