public void solve(int testNumber, InputReader in, PrintWriter out) {
    n = in.nextInt();
    a = new ArrayList[n];
    int m = in.nextInt();
    int k = in.nextInt();
    ArrayList<Integer> spe = new ArrayList<>();
    ArrayList<node> ks = new ArrayList<node>();
    for (int i = 0; i < k; i++) spe.add(in.nextInt() - 1);
    for (int i = 0; i < n; i++) a[i] = new ArrayList<>();
    for (int i = 0; i < m; i++) {
        int c = in.nextInt() - 1;
        int b = in.nextInt() - 1;
        a[c].add(b);
        a[b].add(c);
    }
    int[][] dist = new int[2][n];
    bfs(dist[0], 0);
    bfs(dist[1], n - 1);
    int ans = dist[0][n - 1];
    for (int i = 0; i < k; i++) {
        ks.add(new node(dist[0][spe.get(i)], dist[1][spe.get(i)]));
    }
    Collections.sort(ks, new Comparator<node>() {

        public int compare(node o1, node o2) {
            return (o1.x - o1.y) - (o2.x - o2.y);
        }
    });
    int best = -1;
    int[] suf = new int[k];
    suf[k - 1] = Integer.MIN_VALUE;
    for (int i = k - 2; i >= 0; i--) {
        suf[i] = Math.max(ks.get(i + 1).y, suf[i + 1]);
    }
    for (int i = 0; i < k; i++) {
        best = Math.max(best, ks.get(i).x + suf[i] + 1);
    }
    out.print(Math.min(ans, best));
}