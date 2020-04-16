public void solve(InputReader in, PrintWriter out) {
    this.in = in;
    this.out = out;
    n = in.readInt();
    m = in.readInt();
    graph = new ArrayList[n + 1];
    directions = new ArrayList[n + 1];
    for (int i = 1; i <= n; i++) {
        graph[i] = new ArrayList<>();
        directions[i] = new ArrayList<>();
    }
    for (int i = 0; i < m; i++) {
        int from = in.readInt();
        int to = in.readInt();
        graph[to].add(from);
    }
    s = in.readInt();
    path = new int[s];
    in.readIntArrays(path);
    lengthFrom = new int[n + 1];
    for (int i = 1; i <= n; i++) lengthFrom[i] = Integer.MAX_VALUE;
    lengthFrom[path[s - 1]] = 0;
    bfs(path[s - 1]);
    int minChange = 0;
    int maxChange = 0;
    for (int i = 0; i < s - 1; i++) {
        int c = path[i];
        int n = path[i + 1];
        boolean goodDir = directions[c].contains(n);
        if (!goodDir) {
            minChange++;
            maxChange++;
        } else if (directions[c].size() > 1) {
            maxChange++;
        }
    }
    out.print(minChange);
    out.print(' ');
    out.print(maxChange);
}