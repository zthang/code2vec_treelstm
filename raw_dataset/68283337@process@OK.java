static void process() throws Exception {
    // log("hello");
    out = new BufferedWriter(new OutputStreamWriter(System.out));
    reader = new InputReader(System.in);
    int n = reader.readInt();
    stack = new int[n];
    anc = new int[n];
    friends = new ArrayList[n];
    for (int u = 0; u < n; u++) friends[u] = new ArrayList<Integer>();
    below = new int[n];
    int root = 0;
    for (int u = 0; u < n; u++) {
        int v = reader.readInt() - 1;
        anc[u] = v;
        if (v >= 0)
            friends[v].add(u);
        below[u] = reader.readInt();
        if (anc[u] == -1)
            root = u;
    }
    // for (int u=0;u<n;u++)
    // log(friends[u]);
    sub = new int[n];
    ar = new int[n];
    min = new int[n];
    max = new int[n];
    Arrays.fill(min, Integer.MAX_VALUE);
    Arrays.fill(max, Integer.MIN_VALUE);
    computeSub(root);
    // log(sub);
    idx = 0;
    int res = explore(root, 1);
    if (res < 0) {
        output("NO");
    } else {
        output("YES");
        for (int i = 0; i < n; i++) {
            outputWln(ar[i] + " ");
        }
        output("");
    }
    try {
        out.close();
    } catch (Exception Ex) {
    }
}