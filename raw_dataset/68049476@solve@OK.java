static void solve() throws IOException {
    scan = new FastReader();
    pw = new PrintWriter(System.out, true);
    StringBuilder sb = new StringBuilder();
    int t = ni();
    while (t-- > 0) {
        int n = ni();
        int[] to = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            int a_i = ni();
            to[i] = i - a_i;
        }
        int[] in_time = new int[n + 1];
        Arrays.fill(in_time, -1);
        int cycle_start = -1, len = -1;
        int curr = 1;
        in_time[curr] = 0;
        while (true) {
            if (in_time[to[curr]] == -1) {
                in_time[to[curr]] = in_time[curr] + 1;
                curr = to[curr];
            } else {
                len = in_time[curr] - in_time[to[curr]] + 1;
                cycle_start = to[curr];
                break;
            }
        }
        sb.append(len);
        sb.append("\n");
        sb.append(cycle_start);
        sb.append(" ");
        curr = to[cycle_start];
        while (curr != cycle_start) {
            sb.append(curr);
            sb.append(" ");
            curr = to[curr];
        }
        sb.append("\n");
    }
    psb(sb);
    pw.flush();
    pw.close();
}