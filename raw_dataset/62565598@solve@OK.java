public void solve(int testNumber, inputClass sc, PrintWriter out) {
    n = sc.nextInt();
    c = new long[3][n];
    for (int j = 0; j < 3; j++) {
        for (int i = 0; i < n; i++) {
            c[j][i] = sc.nextInt();
        }
    }
    graph = new DPaintTheTree.Node[n];
    for (int i = 0; i < n; i++) {
        graph[i] = new DPaintTheTree.Node();
        graph[i].edges = new ArrayList<>();
    }
    for (int i = 0; i < n - 1; i++) {
        int x = sc.nextInt() - 1;
        int y = sc.nextInt() - 1;
        graph[x].edges.add(y);
        graph[y].edges.add(x);
    }
    int start = -1;
    for (int i = 0; i < n; i++) {
        if (graph[i].edges.size() == 1) {
            start = i;
            break;
        }
    }
    o = true;
    perm = new ArrayList<>();
    dfs(start, -1);
    if (!o) {
        out.println(-1);
        return;
    }
    long best = Long.MAX_VALUE;
    ArrayList<Integer> ans = new ArrayList<>();
    for (int f = 0; f < 3; f++) {
        for (int s = 0; s < 3; s++) {
            if (s != f) {
                ArrayList<Integer> t = new ArrayList<>();
                t.add(f + 1);
                t.add(s + 1);
                long act = c[f][perm.get(0)] + c[s][perm.get(1)];
                for (int i = 2; i < n; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (j + 1 != t.get(t.size() - 1) && j + 1 != t.get(t.size() - 2)) {
                            t.add(j + 1);
                            act += c[j][perm.get(i)];
                            break;
                        }
                    }
                }
                if (act < best) {
                    ans = t;
                    best = act;
                }
            }
        }
    }
    out.println(best);
    int[] toprint = new int[n];
    for (int i = 0; i < n; i++) {
        toprint[perm.get(i)] = ans.get(i);
    }
    for (int i : toprint) {
        out.print(i + " ");
    }
    out.println();
}