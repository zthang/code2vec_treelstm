public void solve(int testNumber, ScanReader in, PrintWriter out) {
    int n = in.scanInt();
    int[] xi = new int[n];
    int[] yi = new int[n];
    for (int i = 0; i < n; i++) {
        xi[i] = in.scanInt();
        yi[i] = in.scanInt();
    }
    int[] ci = new int[n];
    int[] ki = new int[n];
    for (int i = 0; i < n; i++) ci[i] = in.scanInt();
    for (int i = 0; i < n; i++) ki[i] = in.scanInt();
    PriorityQueue<long[]> pair = new PriorityQueue<>(new Comparator<long[]>() {

        public int compare(long[] o1, long[] o2) {
            return Long.signum(o1[0] - o2[0]);
        }
    });
    ArrayList<int[]> edges = new ArrayList<>();
    ArrayList<Integer> build = new ArrayList<>();
    long[] reached = new long[n];
    boolean[] done = new boolean[n];
    for (int i = 0; i < n; i++) {
        pair.add(new long[] { ci[i], i, -1 });
        reached[i] = ci[i];
    }
    while (pair.size() > 0) {
        long[] pai = pair.poll();
        if (done[(int) pai[1]])
            continue;
        done[(int) pai[1]] = true;
        if (pai[2] == -1) {
            build.add((int) pai[1]);
        } else {
            edges.add(new int[] { (int) pai[2], (int) pai[1] });
        }
        for (int i = 0; i < n; i++) {
            if (done[i])
                continue;
            long newcost = (ki[i] + ki[(int) pai[1]] + 0l) * (Math.abs(xi[i] - xi[(int) pai[1]]) + Math.abs(yi[i] - yi[(int) pai[1]]));
            if (newcost < reached[i]) {
                pair.add(new long[] { newcost, i, pai[1] });
                reached[i] = newcost;
            }
        }
    }
    long ans = 0;
    for (long l : reached) ans += l;
    out.println(ans);
    out.println(build.size());
    for (int i : build) out.print((i + 1) + " ");
    out.println();
    out.println(edges.size());
    for (int[] p : edges) out.println((p[0] + 1) + " " + (p[1] + 1));
}