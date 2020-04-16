public void solve(int testNumber, InputReader in, PrintWriter out) {
    int n = in.nextInt();
    tree = new ArrayList[n];
    c = new long[n][3];
    for (int j = 0; j < 3; j++) {
        for (int i = 0; i < n; i++) {
            c[i][j] = in.nextInt();
        }
    }
    for (int i = 0; i < n; i++) tree[i] = new ArrayList<>();
    for (int i = 0; i < n - 1; i++) {
        int u = in.nextInt() - 1;
        int v = in.nextInt() - 1;
        tree[u].add(v);
        tree[v].add(u);
    }
    int st = -1;
    for (int i = 0; i < n; i++) {
        if (tree[i].size() > 2) {
            out.println(-1);
            return;
        }
        if (tree[i].size() == 1) {
            st = i;
        }
    }
    ArrayList<Integer> ord = new ArrayList<>();
    int prev = -1;
    for (int i = 0; i < n; i++) {
        ord.add(st);
        for (int v : tree[st]) {
            if (v != prev) {
                prev = st;
                st = v;
                break;
            }
        }
    }
    long[][] cost = new long[3][3];
    for (int i = 0; i < 3; i++) {
        for (int color = 0; color < 3; color++) {
            for (int vert = i; vert < ord.size(); vert += 3) {
                cost[i][color] += c[ord.get(vert)][color];
            }
        }
    }
    long ans = Long.MAX_VALUE;
    int[] cc = new int[3];
    for (int c1 = 0; c1 < 3; c1++) {
        for (int c2 = 0; c2 < 3; c2++) {
            for (int c3 = 0; c3 < 3; c3++) {
                if (c1 != c2 && c1 != c3 && c2 != c3) {
                    long v = cost[0][c1] + cost[1][c2] + cost[2][c3];
                    if (v < ans) {
                        ans = v;
                        cc[0] = c1;
                        cc[1] = c2;
                        cc[2] = c3;
                    }
                }
            }
        }
    }
    int[] colors = new int[n];
    for (int i = 0; i < 3; i++) {
        for (int vert = i; vert < ord.size(); vert += 3) {
            colors[ord.get(vert)] = cc[i] + 1;
        }
    }
    out.println(ans);
    for (int i = 0; i < n; i++) {
        out.print(colors[i] + " ");
    }
}