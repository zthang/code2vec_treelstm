public void run() {
    FastScanner fs = new FastScanner();
    PrintWriter out = new PrintWriter(System.out);
    System.err.println("");
    int ptr = 0;
    dominos = new int[21][2];
    used = new boolean[21];
    for (int i = 1; i <= 6; i++) {
        for (int j = i; j <= 6; j++) {
            dominos[ptr][0] = i;
            dominos[ptr++][1] = j;
        }
    }
    n = fs.nextInt();
    int m = fs.nextInt();
    edges = new int[m][2];
    adj = new ArrayList[n];
    for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
    for (int i = 0; i < m; i++) {
        edges[i][0] = fs.nextInt() - 1;
        edges[i][1] = fs.nextInt() - 1;
        adj[edges[i][0]].add(edges[i][1]);
        adj[edges[i][1]].add(edges[i][0]);
    }
    assigned = new int[n];
    Arrays.fill(assigned, -1);
    buildAssign(new int[n], 0);
    out.println(res);
    out.close();
}