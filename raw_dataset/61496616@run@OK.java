public void run(FastScanner sc, FastPrinter out) throws Exception {
    int N = sc.nextInt();
    int M = sc.nextInt();
    int[][] adj = sc.readGraph(N, M, true, true);
    int[] color = new int[N];
    Arrays.fill(color, 1);
    int head = -1;
    for (int e : adj[0]) {
        color[e] = 2;
        head = e;
    }
    boolean broken = false;
    if (head != -1) {
        boolean assigned = false;
        for (int e : adj[head]) {
            if (color[e] == 2) {
                color[e] = 3;
                assigned = true;
            }
        }
        if (!assigned) {
            broken = true;
        } else {
            broken = verify(adj, color, N);
        }
    } else {
        broken = true;
    }
    if (broken) {
        out.println(-1);
        return;
    }
    for (int i = 0; i < N; i++) {
        if (i > 0)
            out.print(' ');
        out.print(color[i]);
    }
    out.println();
}