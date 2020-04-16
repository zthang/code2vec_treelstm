public void solve(int testNumber, InputReader in, PrintWriter out) {
    int N = in.nextInt();
    int counterIter = 0;
    for (int first = 0; first < 3; first++) {
        for (int second = 0; second < 3; second++) {
            for (int third = 0; third < 3; third++) {
                if (first != second && second != third && first != third) {
                    order[counterIter][0] = first;
                    order[counterIter][1] = second;
                    order[counterIter][2] = third;
                    counterIter++;
                }
            }
        }
    }
    tree = new TaskD.Node[N];
    for (int i = 0; i < N; i++) {
        tree[i] = new TaskD.Node(i);
    }
    long[][] costs = new long[N][3];
    for (int j = 0; j < 3; j++) {
        for (int i = 0; i < N; i++) {
            costs[i][j] = in.nextLong();
        }
    }
    for (int i = 0; i < N - 1; i++) {
        int a = in.nextInt() - 1;
        int b = in.nextInt() - 1;
        tree[a].ch.add(b);
        tree[b].ch.add(a);
    }
    for (int i = 0; i < N; i++) {
        if (tree[i].ch.size() >= 3) {
            out.println(-1);
            return;
        }
    }
    int root = 0;
    for (int i = 0; i < N; i++) {
        if (tree[i].ch.size() == 1) {
            root = i;
            root(i, -1);
            break;
        }
    }
    for (int i = 0; i < N; i++) {
        tree[i].ch.remove((Object) tree[i].p);
    }
    long min = Long.MAX_VALUE;
    int ordering = -1;
    for (int i = 0; i < 6; i++) {
        long res = 0;
        int node = root;
        for (int j = 0; j < N; j++) {
            res += costs[node][order[i][j % 3]];
            if (tree[node].ch.size() != 0) {
                node = tree[node].ch.get(0);
            }
        }
        if (res < min) {
            min = res;
            ordering = i;
        }
    }
    out.println(min);
    int[] coloring = new int[N];
    int node = root;
    for (int j = 0; j < N; j++) {
        coloring[node] = order[ordering][j % 3] + 1;
        if (tree[node].ch.size() > 0) {
            node = tree[node].ch.get(0);
        }
    }
    for (int val : coloring) {
        out.print(val + " ");
    }
}