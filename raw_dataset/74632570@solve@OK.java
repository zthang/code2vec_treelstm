public void solve(int testNumber, ScanReader in, PrintWriter out) {
    int n = in.scanInt();
    int m = in.scanInt();
    int[] from = new int[n - 1];
    int[] to = new int[n - 1];
    for (int i = 0; i < n - 1; i++) {
        from[i] = in.scanInt();
        to[i] = in.scanInt();
    }
    inT = new int[n + 1];
    outT = new int[n + 1];
    depth = new int[n + 1];
    parent = new int[n + 1];
    time = 0;
    G = CodeHash.packGraph(from, to, n);
    depth(1, -1);
    while (m-- > 0) {
        int k = in.scanInt();
        int[] nodes = new int[k];
        for (int i = 0; i < k; i++) nodes[i] = in.scanInt();
        int highest = 0;
        for (int i = 0; i < k; i++) if (depth[nodes[i]] > depth[nodes[highest]])
            highest = i;
        boolean flag = true;
        for (int i = 0; i < k; i++) {
            if (isA(nodes[i], nodes[highest]) || isA(parent[nodes[i]], nodes[highest]))
                continue;
            flag = false;
            break;
        }
        if (flag)
            out.println("YES");
        else
            out.println("NO");
    }
}