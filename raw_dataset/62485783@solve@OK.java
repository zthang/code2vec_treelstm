private void solve() throws IOException {
    int n = in.nextInt();
    int[][] colors = new int[3][n + 1];
    for (int i = 0; i < 3; i++) {
        for (int j = 1; j <= n; j++) {
            colors[i][j] = in.nextInt();
        }
    }
    List<List<Integer>> ways = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
        ways.add(new ArrayList<>());
    }
    for (int i = 0; i < n - 1; i++) {
        int u = in.nextInt();
        int v = in.nextInt();
        ways.get(u).add(v);
        ways.get(v).add(u);
    }
    int one = -1;
    int pointer = 0;
    for (List<Integer> node : ways) {
        if (node.size() > 2) {
            out.println(-1);
            return;
        }
        if (node.size() == 1) {
            one = pointer;
        }
        pointer++;
    }
    List<Integer> way = new ArrayList<>();
    if (one == -1) {
        if (n % 3 != 0) {
            out.println(-1);
            return;
        }
        one = 1;
    }
    int next = ways.get(one).get(0);
    int prev = one;
    way.add(one);
    while (next != one) {
        way.add(next);
        if (ways.get(next).size() == 1) {
            break;
        }
        if (ways.get(next).get(0) == prev) {
            prev = next;
            next = ways.get(next).get(1);
        } else {
            prev = next;
            next = ways.get(next).get(0);
        }
    }
    long ans = Long.MAX_VALUE;
    int[][] patterns = new int[][] { { 0, 1, 2 }, { 0, 2, 1 }, { 1, 0, 2 }, { 1, 2, 0 }, { 2, 0, 1 }, { 2, 1, 0 } };
    int[] ansP = new int[n + 1];
    for (int[] pattern : patterns) {
        long cur = 0;
        int[] curP = new int[n + 1];
        for (int i = 0; i < way.size(); i++) {
            int node = way.get(i);
            int color = pattern[i % 3];
            cur += colors[color][node];
            curP[node] = color + 1;
        }
        if (cur < ans) {
            ans = cur;
            System.arraycopy(curP, 1, ansP, 1, n);
        }
    }
    out.println(ans);
    for (int i = 1; i <= n; i++) {
        out.print(ansP[i] + " ");
    }
}