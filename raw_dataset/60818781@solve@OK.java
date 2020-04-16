public void solve(int testNumber, FastReader scan, PrintWriter out) {
    n = scan.nextInt();
    m = scan.nextInt();
    graph = new ArrayList[n];
    weight = new long[n];
    visited = new boolean[n];
    disc = new int[n];
    low = new int[n];
    parent = new int[n];
    not = new HashSet[n];
    component = new int[n];
    for (int i = 0; i < n; i++) {
        graph[i] = new ArrayList<Integer>();
        not[i] = new HashSet<Integer>();
        weight[i] = scan.nextLong();
        parent[i] = -1;
        component[i] = -1;
    }
    for (int i = 0; i < m; i++) {
        int a = scan.nextInt() - 1, b = scan.nextInt() - 1;
        graph[a].add(b);
        graph[b].add(a);
    }
    for (int i = 0; i < n; i++) {
        if (!visited[i]) {
            getBridges(i);
        }
    }
    int currentId = 0;
    for (int i = 0; i < n; i++) {
        if (component[i] == -1)
            addMetaNode(i, currentId++);
    }
    metaWeight = new long[currentId];
    metaGraph = new ArrayList[currentId];
    size = new int[currentId];
    comeBack = new boolean[currentId];
    for (int i = 0; i < n; i++) {
        metaWeight[component[i]] += weight[i];
        size[component[i]]++;
    }
    for (int i = 0; i < currentId; i++) metaGraph[i] = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        for (int j : not[i]) {
            metaGraph[component[i]].add(component[j]);
        }
    }
    int from = scan.nextInt() - 1;
    comeBack[component[from]] = true;
    long ans = dfs(-1, component[from]);
    long maxTerminalWeight = 0;
    for (int i = 0; i < currentId; i++) {
        if (comeBack[i]) {
            maxTerminalWeight = Math.max(maxTerminalWeight, getTerminal(-1, i));
        }
    }
    ans += maxTerminalWeight;
    out.println(ans);
}