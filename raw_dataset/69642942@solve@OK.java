public void solve(int testNumber, InputReader in, PrintWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    long[] nodeWeight = new long[n];
    for (int i = 0; i < n; i++) {
        nodeWeight[i] = in.nextInt();
    }
    ArrayList<Integer>[] adj = new ArrayList[n];
    for (int i = 0; i < n; i++) {
        adj[i] = new ArrayList<>();
    }
    for (int i = 0; i < m; i++) {
        int a = in.nextInt() - 1;
        int b = in.nextInt() - 1;
        adj[a].add(b);
        adj[b].add(a);
    }
    int start = in.nextInt() - 1;
    int[] deg = new int[n];
    for (int i = 0; i < n; i++) {
        deg[i] = adj[i].size();
    }
    PriorityQueue<Node> pq = new PriorityQueue<>();
    for (int i = 0; i < n; i++) {
        if (deg[i] == 1)
            pq.add(new Node(i, deg[i]));
    }
    boolean[] oneWay = new boolean[n];
    while (!pq.isEmpty()) {
        Node head = pq.poll();
        if (deg[head.id] != 1)
            continue;
        oneWay[head.id] = true;
        for (int neighborID : adj[head.id]) {
            if (oneWay[neighborID] == true)
                continue;
            deg[neighborID]--;
            if (deg[neighborID] == 1)
                pq.add(new Node(neighborID, deg[neighborID]));
        }
    }
    adjTree = new TreeSet[n];
    for (int i = 0; i < n; i++) {
        adjTree[i] = new TreeSet<>();
        for (int neighbor : adj[i]) adjTree[i].add(neighbor);
    }
    w = new long[n];
    root = new int[n];
    for (int i = 0; i < n; i++) {
        w[i] = nodeWeight[i];
        root[i] = i;
    }
    int index = -1;
    for (int i = 0; i < n; i++) {
        if (oneWay[i] == false) {
            index = i;
            break;
        }
    }
    if (deg[index] > 1) {
        for (int i = 0; i < n; i++) {
            if (oneWay[i] == false) {
                merge(index, i);
            }
        }
        parent = new int[n];
        dfs(root(start), -1, adjTree);
        int nodeID = index;
        while (nodeID != -1) {
            merge(index, nodeID);
            nodeID = parent[nodeID];
        }
    }
    long ans = rec(root(start), -1, adjTree);
    out.println(ans);
}