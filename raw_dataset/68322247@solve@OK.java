public void solve(int testNumber, InputReader in, PrintWriter out) {
    N = in.nextInt();
    tree = new Node[N];
    for (int i = 0; i < N; i++) {
        tree[i] = new Node();
    }
    int rt = 0;
    for (int i = 0; i < N; i++) {
        int pi = in.nextInt() - 1;
        int ci = in.nextInt();
        if (pi == -1) {
            rt = i;
        } else {
            tree[pi].ch.add(i);
        }
        tree[i].ci = ci;
    }
    dfs(rt);
    if (!flag) {
        out.println("NO");
    } else {
        int[] res = new int[N];
        out.println("YES");
        for (int i = 0; i < N; i++) {
            res[tree[rt].nums.arr[i]] = (i + 1);
        }
        for (int j : res) {
            out.print(j + " ");
        }
    }
}