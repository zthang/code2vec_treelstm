void run() throws IOException {
    int n = nextInt();
    graph = new ArrayList[n];
    for (int i = 0; i < graph.length; i++) {
        graph[i] = new ArrayList<>();
    }
    int[][] otr = new int[n][2];
    int[] event = new int[2 * n + 1];
    TreeMap<Integer, point> ended = new TreeMap<>();
    Arrays.fill(event, -1);
    for (int i = 0; i < n; i++) {
        int l = nextInt();
        int r = nextInt();
        otr[i][0] = l;
        otr[i][1] = r;
        event[l] = i;
    }
    int edges = 0;
    for (int i = 0; i < event.length; i++) {
        if (edges > n - 1) {
            pw.print("NO");
            pw.close();
            return;
        }
        if (event[i] == -1)
            continue;
        int pos = event[i];
        int r = otr[pos][1];
        Integer left_r = ended.lowerKey(r);
        while (left_r != null && i < left_r) {
            edges++;
            graph[pos].add(ended.get(left_r).id);
            graph[ended.get(left_r).id].add(pos);
            left_r = ended.lowerKey(left_r);
        }
        ended.put(r, new point(i, pos));
    }
    used = new boolean[n];
    int cnt = 0;
    for (int i = 0; i < used.length; i++) {
        if (!used[i]) {
            dfs(i);
            cnt++;
        }
    }
    if (cnt > 1)
        pw.print("NO");
    else
        pw.print("YES");
    pw.close();
}