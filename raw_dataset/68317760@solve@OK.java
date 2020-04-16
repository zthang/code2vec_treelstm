public void solve(int testNumber, InputReader s, PrintWriter w) {
    int n = s.nextInt();
    adj = new ArrayList[n];
    for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
    c = new int[n];
    int root = -1;
    for (int i = 0; i < n; i++) {
        int p = s.nextInt() - 1;
        if (p != -1)
            adj[p].add(i);
        else
            root = i;
        c[i] = s.nextInt();
    }
    res = true;
    ArrayList<Integer> ans = dfs(root);
    if (res) {
        w.println("YES");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[ans.get(i)] = i + 1;
        for (int i = 0; i < n; i++) w.print(a[i] + " ");
        w.println();
    } else
        w.println("NO");
}