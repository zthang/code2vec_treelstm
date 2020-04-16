static void process() throws Exception {
    out = new BufferedWriter(new OutputStreamWriter(System.out));
    reader = new InputReader(System.in);
    int n = reader.readInt();
    int m = reader.readInt();
    friends = new ArrayList[n];
    for (int u = 0; u < n; u++) friends[u] = new ArrayList<Integer>();
    for (int i = 0; i < m; i++) {
        int u = reader.readInt() - 1;
        int v = reader.readInt() - 1;
        friends[u].add(v);
        friends[v].add(u);
    }
    solve();
    try {
        out.close();
    } catch (Exception e) {
    }
}