public void solve(int testNumber, InputReader in, PrintWriter out) {
    this.out = out;
    N = in.nextInt();
    arr = new ArrayList<>();
    adj = new ArrayList[N];
    for (int i = 1; i <= N; i++) {
        arr.add(new int[] { i, in.nextInt() });
        arr.add(new int[] { -i, in.nextInt() });
    }
    removed = new boolean[2 * N];
    next = new int[2 * N];
    for (int i = 0; i < 2 * N; i++) {
        next[i] = i - 1;
    }
    Collections.sort(arr, new Comparator<int[]>() {

        public int compare(int[] o1, int[] o2) {
            return Integer.compare(o1[1], o2[1]);
        }
    });
    for (int i = 0; i < 2 * N; i++) {
        if (arr.get(i)[0] < 0) {
            removed[i] = true;
        }
    }
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < 2 * N; i++) {
        if (removed[i]) {
            int cur = -arr.get(i)[0];
            int u = next[i];
            while (arr.get(u)[0] != cur) {
                stack.add(u);
                if (arr.get(u)[0] > 0) {
                    adj[cur - 1].add(arr.get(u)[0] - 1);
                    adj[arr.get(u)[0] - 1].add(cur - 1);
                    edgeCnt++;
                    if (edgeCnt >= N) {
                        out.println("NO");
                        return;
                    }
                }
                u = next[u];
            }
            removed[u] = true;
            int last = next[u];
            while (!stack.isEmpty()) {
                int ind = stack.pop();
                next[ind] = last;
                if (!removed[ind]) {
                    last = ind;
                }
            }
        } else {
            adj[arr.get(i)[0] - 1] = new ArrayList<>();
        }
    }
    visited = new boolean[N];
    root(0, 0);
    if (nodeCnt == N && flag) {
        out.println("YES");
    } else {
        out.println("NO");
    }
}