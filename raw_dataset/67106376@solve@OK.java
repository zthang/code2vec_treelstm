public void solve(int testNumber, ScanReader in, PrintWriter out) {
    int n = in.scanInt();
    int m = in.scanInt();
    long[][] ar = new long[n][2];
    for (int i = 0; i < n; i++) ar[i][1] = i;
    for (int i = 0; i < m; i++) {
        int u = in.scanInt() - 1;
        int v = in.scanInt() - 1;
        int d = in.scanInt();
        ar[u][0] += d;
        ar[v][0] -= d;
    }
    Arrays.sort(ar, new Comparator<long[]>() {

        public int compare(long[] o1, long[] o2) {
            return Long.signum(o1[0] - o2[0]);
        }
    });
    int pointer1 = 0;
    int pointer2 = n - 1;
    ArrayList<long[]> ans = new ArrayList<>();
    while (pointer1 < pointer2) {
        if (ar[pointer1][0] == 0 || ar[pointer2][0] == 0)
            break;
        if (-ar[pointer1][0] > ar[pointer2][0]) {
            ans.add(new long[] { ar[pointer1][1], ar[pointer2][1], ar[pointer2][0] });
            ar[pointer1][0] += ar[pointer2][0];
            ar[pointer2][0] = 0;
            pointer2--;
        } else if (-ar[pointer1][0] < ar[pointer2][0]) {
            ans.add(new long[] { ar[pointer1][1], ar[pointer2][1], -ar[pointer1][0] });
            ar[pointer2][0] += ar[pointer1][0];
            ar[pointer1][0] = 0;
            pointer1++;
        } else {
            ans.add(new long[] { ar[pointer1][1], ar[pointer2][1], -ar[pointer1][0] });
            ar[pointer1][0] = 0;
            ar[pointer2][0] = 0;
            pointer1++;
            pointer2--;
        }
    }
    for (int i = 0; i < n; i++) if (ar[i][0] != 0)
        throw new RuntimeException();
    out.println(ans.size());
    for (long[] p : ans) out.println((p[1] + 1) + " " + (p[0] + 1) + " " + p[2]);
}