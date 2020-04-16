@SuppressWarnings("unchecked")
void solve(FastScanner s, PrintWriter out) {
    N = s.nextInt();
    M = s.nextInt();
    adj = new ArrayList[N];
    vis = new boolean[N];
    trees = new ArrayList<>();
    w = new long[N];
    for (int i = 0; i < N; i++) {
        adj[i] = new ArrayList<>();
        wtot += w[i] = s.nextLong();
    }
    for (int i = 0; i < M; i++) {
        int u = s.nextInt() - 1, v = s.nextInt() - 1;
        adj[u].add(new int[] { u, v });
        adj[v].add(new int[] { v, u });
    }
    S = s.nextInt() - 1;
    precomp(S);
    long down = 0, mx = 0;
    Arrays.fill(sum = new long[N], -1);
    for (int[] ted : trees) {
        down = sum(ted[1], ted[0]);
        wtot -= w[ted[1]];
        mx = mx > down ? mx : down;
    }
    out.println(wtot + mx);
}